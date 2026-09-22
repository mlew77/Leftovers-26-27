package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="teleop", group="Linear Opmode")
public class BasicTeleop extends LinearOpMode {

    @Override
    public void runOpMode() {
        // 1. Declare and initialize the 4 drivetrain motors
        DcMotor leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        DcMotor rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        DcMotor leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        DcMotor rightBack = hardwareMap.get(DcMotor.class, "rightBack");

        // 2. Reverse left-side motors so positive power moves the robot forward
        // (Adjust these if your physical robot drives backward or spins instead of strafing)
        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBack.setDirection(DcMotorSimple.Direction.REVERSE);
        rightFront.setDirection(DcMotorSimple.Direction.FORWARD);
        rightBack.setDirection(DcMotorSimple.Direction.FORWARD);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart(); // Wait for the driver to press PLAY

        // 3. Main driver control loop
        while (opModeIsActive()) {
            // gamepad joysticks go from -1 to 1.
            // Note: pushing stick forward gives negative value, so we negate it.
            double y = -gamepad1.left_stick_y; // Forward/Backward
            double x = gamepad1.left_stick_x * 1.1; // Strafe (multiplied by 1.1 to counteract friction)
            double rx = gamepad1.right_stick_x; // Turning


            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1.0);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;

            // Set powers to the motors
            leftFront.setPower(frontLeftPower);
            leftBack.setPower(backLeftPower);
            rightFront.setPower(frontRightPower);
            rightBack.setPower(backRightPower);


            telemetry.addData("Status", "Running");
            telemetry.addData("Front Motors", "Left: %.2f, Right: %.2f", frontLeftPower, frontRightPower);
            telemetry.addData("Back Motors", "Left: %.2f, Right: %.2f", backLeftPower, backRightPower);
            telemetry.update();
        }
    }
}
