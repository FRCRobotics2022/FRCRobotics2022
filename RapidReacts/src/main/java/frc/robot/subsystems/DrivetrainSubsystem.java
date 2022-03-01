// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.RobotMap;

public class DrivetrainSubsystem extends SubsystemBase {
  
  private final CANSparkMax LeftMotorFront = new CANSparkMax(RobotMap.DRIVE_MOTOR_LEFT_FRONT, MotorType.kBrushless); 
  private final CANSparkMax LeftMotorRear = new CANSparkMax(RobotMap.DRIVE_MOTOR_LEFT_REAR, MotorType.kBrushless);
  private final CANSparkMax RightMotorFront = new CANSparkMax(RobotMap.DRIVE_MOTOR_RIGHT_FRONT, MotorType.kBrushless);
  private final CANSparkMax RightMotorRear = new CANSparkMax(RobotMap.DRIVE_MOTOR_RIGHT_REAR, MotorType.kBrushless);



  /** Creates a new DrivetrainSubsystem. */
  public DrivetrainSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }



public void arcadeDrive(double forwardPower, double turnPower) {
  double driveLeftPower = forwardPower - turnPower; 
  double driveRightPower = forwardPower + turnPower;

  LeftMotorFront.set(driveLeftPower * -1);
  LeftMotorRear.set(driveLeftPower * -1);
  RightMotorFront.set(driveRightPower);
  RightMotorRear.set(driveRightPower);

}
}
