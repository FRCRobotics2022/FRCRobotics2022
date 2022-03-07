// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Calibrations;
import frc.robot.RobotMap;

public class ArmSubsystem extends SubsystemBase {
  private final CANSparkMax armMotor = new CANSparkMax(RobotMap.ARM_MOTOR, MotorType.kBrushless);

  boolean _armUp = true;

  /** Creates a new ArmSubsystem. */
  public ArmSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void raise() {
    armMotor.set(Calibrations.ARM_RAISE_POWER);
  }

  public void lower() {
    armMotor.set(Calibrations.ARM_LOWER_POWER);
  }

  public void hold() {
    double holdPower = Calibrations.ARM_HOLD_UP_POWER;

    if (_armUp == false) {
      holdPower = Calibrations.ARM_HOLD_DOWN_POWER;
    }

    armMotor.set(holdPower);
  }

  public void setUp(boolean armUp) {
    _armUp = armUp;
  }
}
