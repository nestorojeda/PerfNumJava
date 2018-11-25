package tools;

public class Iterator implements java.util.Iterator {

    //Global parameters
    private int size;
    private int[] index;
    private boolean hasNext;

    /**
     * @param size - size of the list
     * @param n - number of elements to iterate with
     */
    public Iterator(int size, int n) {
        hasNext = true;
        this.size = size;
        index = new int[n];
        for (int i=0; i<n; i++) index[i] = i;
    }


    /**
     * Returns true if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext(){
        return hasNext;
    }


    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     */
    @Override
    public int[] next(){
        int [] res = index.clone(); //Se copia el estado actual de index para enviarlo una vez se modifique
        //En caso de que el elemento más significativo haya llegado a su última posición, no quedan iteraciones posibles
        if(index[0]== size-index.length){
            hasNext = false;
        } else {
            for (int i = index.length-1; i >= 0; i--) {
                //Busca el primer elemento en la posición menos significativa que no ha llegado a su máximo valor,
                // lo aumenta en una unidad y cambia los elementos del array menos significativos que él
                if (index[i] < size-(index.length-(i))) {
                    index[i]++;
                    for (int j = i+1; j < index.length; j++) {
                        index[j] = index[j-1] + 1;
                    }
                    break;
                }
            }
        }
        return res;
    }
}