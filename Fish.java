public class Fish extends Animal{

    public boolean canEat;

    public Fish(int age, String gender) {
        super(age, gender);
    }

    public void SetCanEat(boolean value){
        canEat = value;
    }

    public boolean isCanEat(){
        return canEat;
    }


}
