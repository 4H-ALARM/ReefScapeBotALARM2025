// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.lib.statehandler;

import frc.lib.config.stateconfig;
import frc.lib.constants.RobotConstants;

/** Add your docs here. */
public enum robotState {
  RESTING(
      new stateconfig(
          RobotConstants.ElevatorConstants.restingheight,
          RobotConstants.EndEffectorConstants.restingrot,
          RobotConstants.EndEffectorConstants.holdspeed)),
  INTAKE(
      new stateconfig(
          RobotConstants.ElevatorConstants.intakeheight,
          RobotConstants.EndEffectorConstants.intakerot,
          RobotConstants.EndEffectorConstants.intakespeed)),

  L1(
      new stateconfig(
          RobotConstants.ElevatorConstants.L1height,
          RobotConstants.EndEffectorConstants.L1rot,
          RobotConstants.EndEffectorConstants.holdspeed)),
  L2(
      new stateconfig(
          RobotConstants.ElevatorConstants.L2height,
          RobotConstants.EndEffectorConstants.L2rot,
          RobotConstants.EndEffectorConstants.holdspeed)),
  L3(
      new stateconfig(
          RobotConstants.ElevatorConstants.L3height,
          RobotConstants.EndEffectorConstants.L3rot,
          RobotConstants.EndEffectorConstants.holdspeed)),
  L4(
      new stateconfig(
          RobotConstants.ElevatorConstants.L4height,
          RobotConstants.EndEffectorConstants.L4rot,
          RobotConstants.EndEffectorConstants.holdspeed)),

  L1Score(
      new stateconfig(
          RobotConstants.ElevatorConstants.L1height,
          RobotConstants.EndEffectorConstants.L1rot,
          RobotConstants.EndEffectorConstants.throwspeed)),
  L2Score(
      new stateconfig(
          RobotConstants.ElevatorConstants.L2height,
          RobotConstants.EndEffectorConstants.L2rot,
          RobotConstants.EndEffectorConstants.throwspeed)),
  L3Score(
      new stateconfig(
          RobotConstants.ElevatorConstants.L3height,
          RobotConstants.EndEffectorConstants.L3rot,
          RobotConstants.EndEffectorConstants.throwspeed)),
  L4Score(
      new stateconfig(
          RobotConstants.ElevatorConstants.L4height,
          RobotConstants.EndEffectorConstants.L4rot,
          RobotConstants.EndEffectorConstants.throwspeed));

  private final stateconfig targetState;

  robotState(stateconfig state) {
    this.targetState = state;
  }

  public stateconfig getState() {
    return this.targetState;
  }
}
