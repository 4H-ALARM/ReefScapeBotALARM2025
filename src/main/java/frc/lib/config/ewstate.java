// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.lib.config;

import edu.wpi.first.math.geometry.Rotation2d;

/** Add your docs here. */
public class ewstate {

    public final Rotation2d elevatorHeightRot;
    public final Rotation2d wristRot;

    public ewstate(Rotation2d elevatorRotation2d, Rotation2d wristRotation2d) {
        this.elevatorHeightRot = elevatorRotation2d;
        this.wristRot = wristRotation2d;
    }



}
