// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.claw;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.lib.statehandler.stateHandler;

public class EndEffector extends SubsystemBase {

  private final ClawIO claw;
  private final WristIO wrist;
  private final stateHandler stateHandler;

  private WristIOInputsAutoLogged wristIOInputsAutoLogged;
  private ClawIOInputsAutoLogged clawIOInputsAutoLogged;

  /** Creates a new EndEffector. */
  public EndEffector(ClawIO clawimpl, WristIO wristimpl, stateHandler handler) {
    this.claw = clawimpl;
    this.wrist = wristimpl;
    this.stateHandler = handler;

    this.wristIOInputsAutoLogged = new WristIOInputsAutoLogged();
    this.clawIOInputsAutoLogged = new ClawIOInputsAutoLogged();
  }

  public void stopWrist() {
    this.wrist.stopMotor();
  }

  public void resetWristEncoder() {
    this.wrist.resetEncoder();
  }

  public boolean getWristResults() {
    if (wrist.getAngle().getRotations()
            > stateHandler.getState().getState().wristRot.getRotations() - 0.3
        && wrist.getAngle().getRotations()
            < stateHandler.getState().getState().wristRot.getRotations() + 0.3) {
      return true;
    }
    return false;
  }

  public boolean getIntaked() {
    return claw.getbeambreak();
  }

  @Override
  public void periodic() {
    this.wrist.setAngle(stateHandler.getState().getState().wristRot);
    this.claw.setSpeed(stateHandler.getState().getState().clawSpeed);
    this.claw.updateInputs();
    this.wrist.updateInputs();
  }
}
