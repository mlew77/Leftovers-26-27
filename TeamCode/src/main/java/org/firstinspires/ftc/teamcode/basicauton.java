package org.firstinspires.ftc.teamcode;

import com.pedropathing.geometry.*;
import com.pedropathing.paths.*;

public class basicauton {

    private final Pose start = new Pose(56, 8, Math.toRadians(90));
    private final Pose path1 = new Pose(56.3137, 35.0588, Math.toRadians(180));
    private final Pose park = new Pose(135.143, 34.388, Math.toRadians(179.5125));
    private final Pose point3 = new Pose(33.7867, 113.5429, Math.toRadians(142.0117));

    public Path path1() {
        Path path = new Path(new BezierLine(start, path1));
        path.setLinearHeadingInterpolation(start.getHeading(), path1.getHeading());
        return path;
    }

    public Path park() {
        Path path = new Path(new BezierLine(path1, park));
        path.setTangentHeadingInterpolation();
        path.reverseHeadingInterpolation();
        return path;
    }

    public Path path3() {
        Path path = new Path(new BezierLine(park, point3));
        path.setTangentHeadingInterpolation();
        return path;
    }
}
