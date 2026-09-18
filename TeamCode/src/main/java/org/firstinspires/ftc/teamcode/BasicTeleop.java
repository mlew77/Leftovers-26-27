package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="Basic Drive", group="Linear Opmode")
public class BasicTeleop extends LinearOpMode {
    private DcMotor leftDrive = null;

    @Override
    public void runOpMode() {
        // 1. Initialize hardware map
        leftDrive = hardwareMap.get(DcMotor.class, "left_drive");

        waitForStart(); // Wait for the driver to press PLAY

        // 2. Loop while the OpMode is active
        while (opModeIsActive()) {
            // Set motor power based on gamepad joystick
            leftDrive.setPower(-gamepad1.left_stick_y);
        }
    }
}
