package Tools;

public class Iterator implements java.util.Iterator {

    //Global parameters
    private boolean[] list;
    private int[] index;
    private boolean hasNext;

    /**
     * @param size - size of the list
     * @param n - number of elements to iterate with
     */
    public Iterator(int size, int n) {
        hasNext = true;
        list = new boolean[size]; //Generamos un array de tipo booleano que representa si se debe tomar un valor o no
        //Establecemos los primeros n elementos a true y el resto a false
        for (int i = 0; i < size; i++) list[i] = i < n;

        //Generamos un array que nos indicará las distintas posiciones de list que retornarán como true
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
    public boolean hasNext() {
        return hasNext;
    }


    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     */
    @Override
    public boolean[] next(){
        boolean[] res = list.clone(); //Se copia el estado actual de la list para enviarlo una vez se modifique
        //En caso de que el elemento más significativo haya llegado a su última posición, no quedan iteraciones posibles
        if(index[0]== list.length-index.length){
            hasNext = false;
        } else {
            for (int i = index.length-1; i >= 0; i--) {
                //Busca el primer elemento en la posición menos significativa que no ha llegado a su máximo valor,
                // lo aumenta en una unidad y cambia los elementos del array menos significativos que él
                if (index[i] < list.length-(index.length-(i))) {
                    list[index[i]]=false;
                    index[i]++;
                    list[index[i]]=true;
                    for (int j = i+1; j < index.length; j++) {
                        list[index[j]]=false;
                        index[j] = index[j-1] + 1;
                        list[index[j]]=true;
                    }
                    break;
                }
            }
        }
        return res;
    }
}