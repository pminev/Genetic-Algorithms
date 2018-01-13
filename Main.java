import BasicGA.MaximizeGenesGA;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        System.out.print("Our population is going to have 10 individuals with  5 genes each.");
        MaximizeGenesGA genesAlgo=new MaximizeGenesGA(10,5);
        genesAlgo.calcFitness();
        System.out.println("Generation "+ genesAlgo.getGenerationCounter() +
                            " Fittest: " + genesAlgo.getFittestFitness());

        Random  rand=new Random();
        while(genesAlgo.getFittestFitness()<5)
        {
            genesAlgo.incrementGenerationCounter();

            genesAlgo.selection();
            genesAlgo.crossover();

            if (rand.nextInt()%7 <5)
            {
                genesAlgo.mutation();
            }

            genesAlgo.addFittestOffspring();
            genesAlgo.calcFitness();
            System.out.println("Generation "+ genesAlgo.getGenerationCounter() +
                    " Fittest: " + genesAlgo.getFittestFitness());
        }

        System.out.println("\nSolution found in generation " + genesAlgo.getGenerationCounter());
        System.out.println("Fitness: "+genesAlgo.getFittestFitness());
        System.out.print("Genes: ");
        genesAlgo.printFittestGenes();

        System.out.println("");

    }
}
