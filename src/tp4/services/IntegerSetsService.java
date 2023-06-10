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
        backtracking(new HashSet<Integer>(), set);
        return solutions;
    }

    public void backtracking(HashSet<Integer> currentSet, HashSet<Integer> remainingSet) {
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

        backtracking(setWithElement, remainingSet);
        backtracking(new HashSet<>(currentSet), remainingSet);
    }

    private int sumElements(HashSet<Integer> set){
        int sum = 0;
        for(Integer i : set){
            sum += i;
        }
        return sum;
    }
}
