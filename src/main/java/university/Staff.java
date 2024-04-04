package university;

public class Staff {
    String name;
    int skill;
    int yearsOfteaching;

    int stamina;

    int noOfStudentsInstructing;

    public int instruct(int numberOfStudents){
        if(this.skill < 100){
            this.skill += 1;
        }

        this.stamina -= Math.ceil((double) numberOfStudents /(20 + this.skill)) * 20;

        return (100 * this.skill)/ (100 + numberOfStudents);
    }

    public void increaseYearsOfTeaching(){
        this.yearsOfteaching++;
    }

    public  int getNoOfStudentsInstructing(){
        return this.noOfStudentsInstructing;
    }

    public void  replenishStamina() {
        if(this.stamina < 80){
            this.stamina += 20;
        }else {
            this.stamina = 100;
        }
    }

    public int getYearsOfteaching(){
        return this.yearsOfteaching;
    }

    public int getStamina(){
        return this.stamina;
    }
    public Staff(String name, int skill){
        this.name = name;
        this.skill = skill;
        this.stamina = 100;
        this.yearsOfteaching = 0;
        this.noOfStudentsInstructing = 0;
    }
}
