package BasicGA;

import java.util.Random;

public class Individual{
    private int fitness;
    private int[] genes;

    public Individual(int numberOfGenes)
    {
        genes=new int[numberOfGenes];
        Random rand=new Random();

        for (int i = 0; i < genes.length; i++)
        {
            genes[i]= rand.nextInt(Integer.SIZE-1) %2;
        }

        fitness=0;
    }

    public void calculateFitness()
    {
        fitness=0;
        for (int i = 0; i < genes.length; i++) {
            fitness += genes[i];
        }
    }


    public int getFitness()
    {
        return fitness;
    }

    public int getNumberOfGenes()
    {
        return genes.length;
    }

    public int getGene(int gene)
    {
        return genes[gene];
    }

    public void setGene(int gene,int value)
    {
        genes[gene]=value;
    }

    public void printGenes() {
        for (int i = 0; i < genes.length; i++) {
            System.out.print(genes[i]);
        }
    }
}
