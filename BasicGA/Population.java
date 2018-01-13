package BasicGA;

public class Population {

    private Individual[] individuals;
    private int fittest;

    public Population(int size,int numberOfGenes )
    {
        individuals=new Individual[size];
        for (int i = 0; i < individuals.length; i++) {
            individuals[i]=new Individual(numberOfGenes);
        }
    }

    public void calcFirness()
    {
        for (int i = 0; i < individuals.length; i++) {
            individuals[i].calculateFitness();
        }
    }

    public Individual getFittest()
    {
        int maxfitness=0;
        int maxIndividual=0;

        for (int i = 0; i < individuals.length; i++) {
            if (maxfitness<=individuals[i].getFitness())
            {
                maxfitness=individuals[i].getFitness();
                maxIndividual=i;
            }
        }

        fittest=maxIndividual;
        return individuals[maxIndividual];
    }

    public Individual getSecondFittest()
    {
        int secMaxFit=0;
        int secMaxIndividual=0;
        for (int i = 0; i < individuals.length; i++) {
            if (secMaxFit<=individuals[i].getFitness() && individuals[i]!= individuals[fittest])
            {
                secMaxFit=individuals[i].getFitness();
                secMaxIndividual=i;
            }
        }
        return individuals[secMaxIndividual];
    }

    public int getLeastFittestIndex()
    {
        int minFit=individuals[1].getNumberOfGenes();
        int leastFitIndividualIndex=0;

        for (int i = 0; i < individuals.length; i++) {
            if (minFit>=individuals[i].getFitness())
            {
                minFit=individuals[i].getFitness();
                leastFitIndividualIndex=i;
            }
        }

        return leastFitIndividualIndex;
    }

    public int numberOfGenes()
    {
        return individuals[0].getNumberOfGenes();
    }

    public void setIndividual(int leastFittestIndex, Individual fittestOffspring) {
        int geneSize= individuals[leastFittestIndex].getNumberOfGenes();
        for (int i = 0; i <geneSize; i++) {
            individuals[leastFittestIndex].setGene(i,fittestOffspring.getGene(i));
        }
    }

    public int getMaxFitness()
    {
        return individuals[fittest].getFitness();
    }
}
