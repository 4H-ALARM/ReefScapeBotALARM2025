// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.lib.statehandler;

import edu.wpi.first.math.geometry.Rotation2d;
import frc.lib.config.ewstate;
import frc.lib.constants.RobotConstants;

/** Add your docs here. */
public enum statesEnum {


    RESTING(new ewstate(RobotConstants.ElevatorConstants.restingheight, RobotConstants.EndEffectorConstants.restingrot)),
    INTAKE(new ewstate(RobotConstants.ElevatorConstants.intakeheight, RobotConstants.EndEffectorConstants.intakerot)),
    L1(new ewstate(RobotConstants.ElevatorConstants.L1height, RobotConstants.EndEffectorConstants.L1rot)),
    L2(new ewstate(RobotConstants.ElevatorConstants.L2height, RobotConstants.EndEffectorConstants.L2rot)),
    L3(new ewstate(RobotConstants.ElevatorConstants.L3height, RobotConstants.EndEffectorConstants.L3rot)),
    L4(new ewstate(RobotConstants.ElevatorConstants.L4height, RobotConstants.EndEffectorConstants.L4rot));

    private final ewstate targetState;

    statesEnum(ewstate state) {
        this.targetState = state;
      }

    public ewstate getState() {
        return this.targetState;
    }



}
