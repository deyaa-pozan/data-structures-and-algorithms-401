package QueueAndStack.Animal;

import QueueAndStack.Node;
import QueueAndStack.Queue;

public class AnimalShelter {


    Queue<Animal> animals = new Queue<>();
    public void enqueue(Animal animal){
        animals.enqueue(animal);
    }

    public Animal dequeue(String pref){
        if(!animals.isEmpty()) {
            Node current = animals.getFront();
            if(isItAnimal(pref , current)){
                return animals.dequeue();
            }
            while (current.getNext() != null) {
                if (isItAnimal(pref , current.getNext())) {
                    Object value = current.getNext().getValue();
                    current.setNext(current.getNext().getNext());
                    animals.setSize(animals.getSize()-1);
                    return (Animal) value;
                }
                current = current.getNext();
            }
        }
            return null;
    }
    public boolean isItAnimal(String pref, Node node){
        if (pref.toLowerCase().equals(Animal.animalType.dog.toString())){
           return node.getValue() instanceof Dog;
        }else if(pref.toLowerCase().equals(Animal.animalType.cat.toString())){
          return   node.getValue() instanceof Cat;
        }else if(node.getValue() instanceof AnotherAnimal) {
//    Stretch Goal
            return true;
        }
        return false;
    }
    public int getSize(){
        return animals.getSize();
    }


    @Override
    public String toString() {
        return "AnimalShelter{" +
                "animalQueue=" + animals +
                '}';
    }
}
