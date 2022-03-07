// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/** Add your docs here. */
public class RobotMap {
    // Joysticks/controllers
    public static final int JOYSTICK_CHANNEL = 0;
    public static final int JOYSTICK_FORWARD_AXIS = 1;
    public static final int JOYSTICK_TURN_AXIS = 4;
    public static final int CUT_POWER_AXIS = 3;

    // Drivetrain
    public static final int DRIVE_MOTOR_LEFT_FRONT = 3;
    public static final int DRIVE_MOTOR_LEFT_REAR = 4;
    public static final int DRIVE_MOTOR_RIGHT_FRONT = 1;
    public static final int DRIVE_MOTOR_RIGHT_REAR = 2;

    // Arm
    // SHOULD BE 5 BUT CHANGED TO 6
    public static final int ARM_MOTOR = 6;
    
    // Intake
    // SHOULD BE 6 BUT CHANGED TO 5
    public static final int INTAKE_MOTOR = 5;
    //public static final int INTAKE_MOTOR = 6;

    // Button bindings
    public static final int ARM_RAISE_BUTTON = 7;
    public static final int ARM_LOWER_BUTTON = 8;
    public static final int INTAKE_COLLECT_BUTTON = 6;
    public static final int INTAKE_EJECT_BUTTON = 5;
}
