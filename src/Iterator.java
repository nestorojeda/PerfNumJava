import java.util.ArrayList;

public class Iterator implements java.util.Iterator {

    private class Node {

        int info;
        Node next;
    }

    private Node front, aux, rear;
    private boolean end= true;

    Iterator(ArrayList<Integer> lista) {
        front = null;
        aux = null;
        rear = null;
        for (int i = 0 ; i < lista.size(); i++) {
            insert(i);
        }


    }

    private void insert(int valor) {
        if (rear == null) {
            rear = new Node();
            front = rear;
        } else {
            rear.next = new Node();
            rear = rear.next;
            aux = front.next;
        }
        rear.info = valor;
    }

    @Override
    public boolean hasNext() {
        return end;
    }

    public int[] next(){
        int[] pos= {front.info,aux.info};
        if (front.info != (-1)) {
            if (aux == rear) {
                if (front.next == rear) {
                    front = new Node();
                    front.info = -1;
                    aux = new Node();
                    aux.info = -1;
                    this.end = false;

                } else {
                    front = front.next;
                    aux = front.next;
                }
            } else {
                aux = aux.next;
            }
        }
        return pos;
    }
}