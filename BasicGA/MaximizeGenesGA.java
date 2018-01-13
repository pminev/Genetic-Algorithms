package BasicGA;

import java.util.Random;

public class MaximizeGenesGA {
    private Population population;
    private Individual fittest;
    private Individual secFittest;
    private int generations;

    public MaximizeGenesGA(int populationNumber, int numberOfGenes)
    {
        population=new Population(populationNumber,numberOfGenes);
        fittest=null;
        secFittest=null;
        generations=0;
    }

    public void calcFitness()
    {
        population.calcFirness();
    }

    //Natural selection is part of algorithm where we choose
    //the best two individuals
    public void selection()
    {
        fittest=population.getFittest();
        secFittest=population.getSecondFittest();
        if(fittest==secFittest)
            System.out.println("Az sym geu");
    }

    //Crossover part where we make the exchange of genes
    //between best two individuals
    public void crossover()
    {
        Random rand=new Random();
        int crossoverPoint=rand.nextInt(population.numberOfGenes());

        for (int i = 0; i < crossoverPoint; i++) {
            int temp=fittest.getGene(i);
            fittest.setGene(i,secFittest.getGene(i));
            secFittest.setGene(i,temp);
        }
    }


    public void mutation()
    {
        Random rand=new Random();
        int mutationPoint=rand.nextInt(population.numberOfGenes());
        fittest.setGene(mutationPoint,fittest.getGene(mutationPoint)==1?0:1);

        mutationPoint=rand.nextInt(population.numberOfGenes());
        secFittest.setGene(mutationPoint,secFittest.getGene(mutationPoint)==1?0:1);
    }

    private Individual getFittestOffspring()
    {
        fittest.calculateFitness();
        secFittest.calculateFitness();

        return ( fittest.getFitness() > secFittest.getFitness() )? fittest : secFittest;
    }

    public void addFittestOffspring()
    {
        int leastFittestIndex=population.getLeastFittestIndex();
        Individual ind=getFittestOffspring();
        population.setIndividual(leastFittestIndex,ind);
    }

    public int getGenerationCounter()
    {
        return generations;
    }

    public void incrementGenerationCounter()
    {
        generations+=1;
    }

    public int getFittestFitness()
    {
        return population.getMaxFitness();
    }


    public void printFittestGenes() {
        Individual max=population.getFittest();
        max.printGenes();
    }
}
