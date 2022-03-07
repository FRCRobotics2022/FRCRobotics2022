// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Calibrations;
import frc.robot.RobotMap;

public class DrivetrainSubsystem extends SubsystemBase {
  
  private final CANSparkMax LeftMotorFront = new CANSparkMax(RobotMap.DRIVE_MOTOR_LEFT_FRONT, MotorType.kBrushless); 
  private final CANSparkMax LeftMotorRear = new CANSparkMax(RobotMap.DRIVE_MOTOR_LEFT_REAR, MotorType.kBrushless);
  private final CANSparkMax RightMotorFront = new CANSparkMax(RobotMap.DRIVE_MOTOR_RIGHT_FRONT, MotorType.kBrushless);
  private final CANSparkMax RightMotorRear = new CANSparkMax(RobotMap.DRIVE_MOTOR_RIGHT_REAR, MotorType.kBrushless);



  /** Creates a new DrivetrainSubsystem. */
  public DrivetrainSubsystem() {
    LeftMotorFront.setOpenLoopRampRate(Calibrations.RAMP_RATE);
    LeftMotorRear.setOpenLoopRampRate(Calibrations.RAMP_RATE);
    RightMotorFront.setOpenLoopRampRate(Calibrations.RAMP_RATE);
    RightMotorRear.setOpenLoopRampRate(Calibrations.RAMP_RATE);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


// Observe the cut power argument that has been added
public void arcadeDrive(double forwardPower, double turnPower, boolean cutPower) {
  double turnCoefficient = .75;
  turnPower = turnPower * turnCoefficient;

  double cutPowerCoefficient = 1;

  if (cutPower == true) {
    cutPowerCoefficient = Calibrations.CUT_POWER_COEFFICIENT;
  }

  double driveLeftPower = forwardPower - turnPower; 
  double driveRightPower = forwardPower + turnPower;

// <<<<<<< casscode05mar2022
  LeftMotorFront.set(driveLeftPower * -1 * cutPowerCoefficient);
  LeftMotorRear.set(driveLeftPower * -1 * cutPowerCoefficient);
  RightMotorFront.set(driveRightPower * cutPowerCoefficient);
  RightMotorRear.set(driveRightPower * cutPowerCoefficient);

}


// Drive forward by calling the drive method with zero turning.
public void driveForward(double power) {
  this.arcadeDrive(power, 0, false);
}
// ==code below before CASS competition updates =====
//    LeftMotorFront.set(driveLeftPower * -1);
//    LeftMotorRear.set(driveLeftPower * -1);
//    RightMotorFront.set(driveRightPower);
//    RightMotorRear.set(driveRightPower);
//  >>>>>>> main

public void stop() {
  this.arcadeDrive(0, 0, false);
}
}




