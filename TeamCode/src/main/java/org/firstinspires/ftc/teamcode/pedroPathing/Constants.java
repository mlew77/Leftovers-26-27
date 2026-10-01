package org.firstinspires.ftc.teamcode.pedroPathing;

import com.pedropathing.follower.Follower;
import com.pedropathing.follower.FollowerConstants;
import com.pedropathing.ftc.FollowerBuilder;
import com.pedropathing.ftc.drivetrains.MecanumConstants;
import com.pedropathing.ftc.localization.constants.PinpointConstants;
import com.pedropathing.paths.PathConstraints;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;

public class Constants {
    public static FollowerConstants followerConstants = new FollowerConstants();
    public static MecanumConstants mecanumConstants = new MecanumConstants();
    public static PinpointConstants pinpointConstants = new PinpointConstants();

    public static PathConstraints pathConstraints = new PathConstraints(0.99, 100, 1, 1);

    static {

        pinpointConstants.hardwareMapName = "pinpoint";

        // Pod offsets from center of robot (in inches)
        pinpointConstants.forwardPodY = 1.0;
        pinpointConstants.strafePodX = -2.5;

        pinpointConstants.distanceUnit = DistanceUnit.INCH;
        pinpointConstants.encoderResolution = GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD;
        pinpointConstants.forwardEncoderDirection = GoBildaPinpointDriver.EncoderDirection.REVERSED;
        pinpointConstants.strafeEncoderDirection = GoBildaPinpointDriver.EncoderDirection.FORWARD;

        // --- Configure Mecanum Drivetrain Motor Names (if different from defaults) ---
        mecanumConstants.leftFrontMotorName = "leftFront";
        mecanumConstants.leftRearMotorName = "leftBack";
        mecanumConstants.rightFrontMotorName = "rightFront";
        mecanumConstants.rightRearMotorName = "rightBack";
    }

    public static Follower createFollower(HardwareMap hardwareMap) {
        return new FollowerBuilder(followerConstants, hardwareMap)
                .mecanumDrivetrain(mecanumConstants)
                .pinpointLocalizer(pinpointConstants)
                .pathConstraints(pathConstraints)
                .build();
    }
}
