package com.patterns.behavioural;

public class MediatorPattern {

	public static void main(String[] args) {
        Commander commander= new CommanderImpl();
        ArmedUnit soldierUnit=new SoldierUnit(commander);
        ArmedUnit tankUnit=new TankUnit(commander);
        commander.registerArmedUnits(soldierUnit, tankUnit);
        commander.startAttack(soldierUnit);
        commander.startAttack(tankUnit);
        commander.ceaseAttack(soldierUnit);
        commander.startAttack(tankUnit);

	}

}

/*
 * Mediator
 * Is an interface that declares methods for communicating with Colleague objects.
 */
interface Commander {
	   void registerArmedUnits(ArmedUnit soldierUnit, ArmedUnit tankUnit);
	    void setAttackStatus(boolean attackStatus);
	    boolean canAttack();
	    void startAttack(ArmedUnit armedUnit);
	    void ceaseAttack(ArmedUnit armedUnit);
	}

/*
 * ConcreteMediator
 * Implements Mediator. This class maintains and coordinates Colleague objects.
 */
class CommanderImpl implements Commander {
    ArmedUnit soldierUnit, tankUnit;
    boolean attackStatus = true;
    @Override
    public void registerArmedUnits(ArmedUnit soldierUnit, ArmedUnit tankUnit) {
        this.soldierUnit = soldierUnit;
        this.tankUnit = tankUnit;
    }
    @Override
    public void setAttackStatus(boolean attackStatus) {
        this.attackStatus = attackStatus;
    }
    @Override
    public boolean canAttack() {
        return attackStatus;
    }
    @Override
    public void startAttack(ArmedUnit armedUnit) {
        armedUnit.attack();
    }
    @Override
    public void ceaseAttack(ArmedUnit armedUnit) {
        armedUnit.stopAttack();
    }
}

interface ArmedUnit {
    void attack();
    void stopAttack();
}

/*
 * Colleague
 * Communicates with its Mediator when their state changes and responds to requests from the Mediator.
 */
class SoldierUnit implements ArmedUnit{
    private Commander commander;
    public SoldierUnit(Commander commander){
        this.commander=commander;
    }
    @Override
    public void attack()
    {
      if(commander.canAttack())
      {
          System.out.println("SoldierUnit: Attacking.....");
          commander.setAttackStatus(false);
      }
       else{
          System.out.println("SoldierUnit: Cannot attack now. Other units attacking....");
      }
    }
    @Override
    public void  stopAttack(){
        System.out.println("SoldierUnit: Stopped Attacking.....");
        commander.setAttackStatus(true);
    }
}

/*
 * Colleague
 * Communicates with its Mediator when their state changes and responds to requests from the Mediator.
 */
class TankUnit implements ArmedUnit{
    private Commander commander;
    public TankUnit(Commander commander){
        this.commander=commander;
    }
    @Override
    public void  attack()
    {
        if(commander.canAttack())
        {
            System.out.println("TankUnit: Attacking.....");
            commander.setAttackStatus(false);
        }
        else{
            System.out.println("TankUnit: Cannot attack now. Other units attacking....");
        }
    }
    @Override
    public void  stopAttack(){
        System.out.println("TankUnit: Stopped attacking.....");
        commander.setAttackStatus(true);
    }
}
