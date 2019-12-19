package ZUOSHEN.第三课;

import java.util.LinkedList;
import java.util.Queue;

public class CatDogQueue {

    public static class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getPetType() {
            return this.type;
        }
    }

    public static class Dog extends Pet {
        public Dog() {
            super("dog");
        }
    }

    public static class Cat extends Pet {
        public Cat() {
            super("cat");
        }
    }

    public static class PetEnterQueue {
        private Pet pet;
        private long index;


        public PetEnterQueue(Pet pet, long index) {
            this.pet = pet;
            this.index = index;
        }


        public Pet getPet() {
            return pet;
        }

        public void setPet(Pet pet) {
            this.pet = pet;
        }

        public long getIndex() {
            return index;
        }

        public void setIndex(long index) {
            this.index = index;
        }

        public String getEnterPetType() {
            return this.pet.getPetType();
        }
    }

        public class DogCat {
            private Queue<PetEnterQueue> dogQ;
            private Queue<PetEnterQueue> catQ;
            private long count;

            public DogCat() {
                this.dogQ = new LinkedList<PetEnterQueue>();
                this.catQ = new LinkedList<PetEnterQueue>();
                this.count = 0;
            }

            public void add(Pet pet) {
                if (pet.getPetType().equals("dog"))
                    this.dogQ.add(new PetEnterQueue(pet, this.count++));
                else if (pet.getPetType().equals("cat"))
                    this.catQ.add(new PetEnterQueue(pet, count++));
                else
                    throw new RuntimeException("err,not dog or cat");

            }
            public Pet pollAll()
            {
                if(! this.catQ.isEmpty() && !this.dogQ.isEmpty())
                {
                    if(this.dogQ.peek().getIndex()<this.catQ.peek().getIndex())
                    {
                        return this.dogQ.poll().getPet();
                    }else{
                        return this.catQ.poll().getPet();
                    }
                }else if(!this.catQ.isEmpty())
                {
                    return this.catQ.poll().getPet();
                }else if(!this.dogQ.isEmpty()){
                    return this.catQ.poll().getPet();
                }else {
                    throw new RuntimeException("err,queue is empty");
                }
            }
            public Dog pollDog() {
                if (!this.isDogQueueEmpty()) {
                    return (Dog) this.dogQ.poll().getPet();
                } else {
                    throw new RuntimeException("Dog queue is empty!");
                }
            }

            public Cat pollCat() {
                if (!this.isCatQueueEmpty()) {
                    return (Cat) this.catQ.poll().getPet();
                } else
                    throw new RuntimeException("Cat queue is empty!");
            }

            public boolean isEmpty() {
                return this.dogQ.isEmpty() && this.catQ.isEmpty();
            }

            public boolean isDogQueueEmpty() {
                return this.dogQ.isEmpty();
            }

            public boolean isCatQueueEmpty() {
                return this.catQ.isEmpty();
            }



        }


    }

