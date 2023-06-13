package tp4.services;
import java.util.HashSet;
import java.util.Iterator;

//Ejercicio 3: Suma de subconjuntos. Dados n números positivos distintos, se desea encontrar todas las
//combinaciones de esos números tal que la suma sea igual a M.

public class IntegerSetsService {
    private HashSet<HashSet<Integer>> solutions;
    private HashSet<Integer> set;
    private int m;

    public IntegerSetsService(HashSet<Integer> set, int m) {
        this.set = set;
        this.m = m;
        this.solutions = new HashSet<>();
    }

    public HashSet<HashSet<Integer>> getAllSubsetsWhoseSumIsM() {
        backtrackingSubsetSumM(new HashSet<Integer>(), set);
        return solutions;
    }

    public void backtrackingSubsetSumM(HashSet<Integer> currentSet, HashSet<Integer> remainingSet) {
        //Condición de corte
        if(remainingSet.isEmpty()){
            if(sumElements(currentSet) == m){
                solutions.add(currentSet);
            }
            return;
        }

        //Podas
        if(sumElements(currentSet) > m || (sumElements(currentSet) + sumElements(remainingSet)) < m){
            return;
        }

        Iterator<Integer> it = remainingSet.iterator();
        Integer element = it.next();
        remainingSet.remove(element);

        HashSet<Integer> setWithElement = new HashSet<>(currentSet);
        setWithElement.add(element);

        backtrackingSubsetSumM(setWithElement, remainingSet);
        backtrackingSubsetSumM(new HashSet<>(currentSet), remainingSet);
    }

    private int sumElements(HashSet<Integer> set){
        int sum = 0;
        for(Integer i : set){
            sum += i;
        }
        return sum;
    }


    //Ejercicio 4: Partición de conjunto. Dado un conjunto de n enteros se desea encontrar, si existe, una partición
    //en dos subconjuntos disjuntos, tal que la suma de sus elementos sea la misma.

    public HashSet<Integer>[] getPartitionIfItExists(){
        HashSet<Integer>[] partition = new HashSet[2];
        partition[0] = new HashSet<Integer>();
        partition[1] = new HashSet<Integer>(set);
        backtrackingPartition(partition);
        return partition;
    }

    private void backtrackingPartition(HashSet<Integer>[] partition){
        HashSet<Integer> leftPartition = partition[0];
        HashSet<Integer> rightPartition = partition[1];
        if(sumElements(leftPartition) == sumElements(rightPartition)){
            return;
        }
       Iterator<Integer> iterator = rightPartition.iterator();
        while(iterator.hasNext()){
            Integer element = iterator.next();
            rightPartition.remove(element);
            leftPartition.add(element);
            backtrackingPartition(partition);
            leftPartition.remove(element);
            rightPartition.add(element);
        }
    }
}
