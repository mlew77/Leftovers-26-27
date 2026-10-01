package org.firstinspires.ftc.teamcode;
import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.Path;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

@Autonomous(name = "basicauton", group = "LinearOpMode")
public class basicauton extends LinearOpMode {

    private Follower follower;
    private final Pose start = new Pose(56, 8, Math.toRadians(90));
    private final Pose point1 = new Pose(56, 39, Math.toRadians(90));
    private final Pose point2 = new Pose(27, 39, Math.toRadians(-180));
    private final Pose point3 = new Pose(84, 39, Math.toRadians(0));
    private final Pose point4 = new Pose(56, 39, Math.toRadians(-180));
    private final Pose point5 = new Pose(56, 8, Math.toRadians(-90));

    private Path path1;
    private Path path2;
    private Path path3;
    private Path path4;
    private Path path5;


    public void buildPaths() {
        path1 = new Path(new BezierLine(start, point1));
        path1.setTangentHeadingInterpolation();

        path2 = new Path(new BezierLine(point1, point2));
        path2.setTangentHeadingInterpolation();

        path3 = new Path(new BezierLine(point2, point3));
        path3.setTangentHeadingInterpolation();

        path4 = new Path(new BezierLine(point3, point4));
        path4.setTangentHeadingInterpolation();

        path5 = new Path(new BezierLine(point4, point5));
        path5.setTangentHeadingInterpolation();
    }

    @Override
    public void runOpMode() {
        follower = Constants.createFollower(hardwareMap);
        follower.setStartingPose(start);
        buildPaths();

        telemetry.addData("Status", "Initialized - Ready to run!");
        telemetry.update();


        waitForStart();

        if (isStopRequested()) return;


        follower.followPath(path1);
        while (opModeIsActive() && follower.isBusy()) {
            follower.update();
            telemetry.addData("Current Path", "Path 1");
            telemetry.addData("Robot Pose", follower.getPose());
            telemetry.update();
        }


        follower.followPath(path2);
        while (opModeIsActive() && follower.isBusy()) {
            follower.update();
            telemetry.addData("Current Path", "Park Path");
            telemetry.addData("Robot Pose", follower.getPose());
            telemetry.update();
        }


        follower.followPath(path3);
        while (opModeIsActive() && follower.isBusy()) {
            follower.update();
            telemetry.addData("Current Path", "Path 3");
            telemetry.addData("Robot Pose", follower.getPose());
            telemetry.update();
        }

        follower.followPath(path4);
        while (opModeIsActive() && follower.isBusy()) {
            follower.update();
            telemetry.addData("Current Path", "Path 3");
            telemetry.addData("Robot Pose", follower.getPose());
            telemetry.update();
        }

        follower.followPath(path5);
        while (opModeIsActive() && follower.isBusy()) {
            follower.update();
            telemetry.addData("Current Path", "Path 3");
            telemetry.addData("Robot Pose", follower.getPose());
            telemetry.update();
        }

        while (opModeIsActive()) {
            follower.update();

        }
    }
}
