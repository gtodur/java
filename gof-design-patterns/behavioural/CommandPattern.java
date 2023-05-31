package com.patterns.behavioural;

public class CommandPattern {

	public static void main(String[] args) {
        RemoteControl remoteControl=new RemoteControl();
        System.out.println("-----Testing onButtonPressed on RemoteControl for Car-----");
        Car car=new Car();
        CommandBase carMoveCommand=new CarMoveCommand(car);
        remoteControl.onButtonPressed(carMoveCommand);
        System.out.println("-----Testing offButtonPressed on RemoteControl for Car-----");
        CommandBase carStopCommand=new CarStopCommand(car);
        remoteControl.offButtonPressed(carStopCommand);
        System.out.println("-----Testing undoButtonPressed() on RemoteControl for Car-----");
        remoteControl.undoButtonPressed();
        System.out.println("-----Testing onButtonPressed on RemoteControl for RotatingTop-----");
        RotatingTop top=new RotatingTop();
        CommandBase topRotateCommand=new TopRotateCommand(top);
        remoteControl.onButtonPressed(topRotateCommand);
        System.out.println("-----Testing offButtonPressed on RemoteControl for RotatingTop-----");
        CommandBase topStopRotateCommand=new TopStopRotateCommand(top);
        remoteControl.offButtonPressed(topStopRotateCommand);
       System.out.println("-----Testing undoButtonPressed on RemoteControl for RotatingTop-----");
        remoteControl.undoButtonPressed();

	}

}

class Car {
    public void move()
    {
        System.out.println("Car is moving");
    }
    public void stop()
    {
        System.out.println("Car has stopped");
    }
}

class RotatingTop {
    public void startRotating(){
        System.out.println("Top has start rotating");
    }
    public void stopRotating(){
        System.out.println("Top has stopped rotating");
    }
}

interface CommandBase {
    void execute();
    void undo();
}

class CarMoveCommand implements CommandBase {
    private Car car;
    public CarMoveCommand(Car car){
        this.car=car;
    }
    @Override
    public void execute(){
       System.out.println("CarMoveCommand.execute(): Invoking move() on Car");
        car.move();
    }
    @Override
    public void undo(){
      System.out.println("CarMoveCommand.undo():  Undoing previous action->Invoking stop() on Car");
      car.stop();
    }
}

class CarStopCommand implements CommandBase{
    private Car car;
    public CarStopCommand(Car car){
        this.car=car;
    }
    @Override
    public void execute(){
        System.out.println("CarStopCommand.execute(): Invoking stop() on Car");
        car.stop();
    }
    @Override
    public void undo()
    {
        System.out.println("CarStopCommand.undo(): Undoing previous action-> Invoking move() on Car");
        car.move();
    }
}

class TopRotateCommand implements CommandBase{
    RotatingTop rotatingTop;
    public  TopRotateCommand(RotatingTop rotatingTop){
        this.rotatingTop=rotatingTop;
    }
    @Override
    public void execute(){
     System.out.println("TopRotateCommand.execute(): Invoking startRotating() on RotatingTop");
      rotatingTop.startRotating();
    }
    @Override
    public void undo(){
        System.out.println("TopRotateCommand.undo(): Undoing previous action->Invoking stopRotating() on RotatingTop");
        rotatingTop.stopRotating();
    }
}

class TopStopRotateCommand implements CommandBase{
    RotatingTop rotatingTop;
    public TopStopRotateCommand(RotatingTop rotatingTop){
        this.rotatingTop=rotatingTop;
    }
    @Override
    public void execute(){
        System.out.println("TopStopRotateCommand.execute(): Invoking stopRotating() on RotatingTop");
        rotatingTop.stopRotating();
    }
    @Override
    public void undo(){
        System.out.println("TopStopRotateCommand.undo(): Undoing previous action->Invoking startRotating() on RotatingTop");
        rotatingTop.startRotating();
    }
}

class RemoteControl {
    CommandBase onCommand, offCommand, undoCommand;
    public void onButtonPressed(CommandBase onCommand){
       this.onCommand=onCommand;
       onCommand.execute();
       undoCommand=onCommand;
    }
    public void offButtonPressed(CommandBase offCommand){
        this.offCommand=offCommand;
        offCommand.execute();
        undoCommand=offCommand;
    }
    public void undoButtonPressed(){
         undoCommand.undo();
    }
}
