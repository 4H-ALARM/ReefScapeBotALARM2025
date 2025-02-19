// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.lib.statehandler;

/** Add your docs here. */
public class stateHandler {

  protected robotState state;

  public stateHandler() {
    state = robotState.RESTING;
  }

  public void setState(robotState givenState) {
    state = givenState;
  }

  public robotState getState() {
    return state;
  }
}
