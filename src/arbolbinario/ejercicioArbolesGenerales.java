package arbolbinario;

public class ejercicioArbolesGenerales {
    public static void main(String[] args) {
        ArbolBinario<String> arbolA = new ArbolBinario(new NodoBinario<String>("A"));
        ArbolBinario<String> arbolB = new ArbolBinario(new NodoBinario<String>("B"));
        ArbolBinario<String> arbolC = new ArbolBinario(new NodoBinario<String>("C"));
        ArbolBinario<String> arbolD = new ArbolBinario(new NodoBinario<String>("D"));
        ArbolBinario<String> arbolE = new ArbolBinario(new NodoBinario<String>("E"));
        ArbolBinario<String> arbolF = new ArbolBinario(new NodoBinario<String>("F"));
        ArbolBinario<String> arbolG = new ArbolBinario(new NodoBinario<String>("G"));

        try {
            arbolA.ponHijoIzq(arbolB);
            arbolA.ponHijoDer(arbolC);
            arbolB.ponHijoIzq(arbolD);

            arbolC.ponHijoIzq(arbolE);
            arbolC.ponHijoDer(arbolF);

            arbolF.ponHijoDer(arbolG);

            preorden(arbolA.raiz);
            System.out.println();

            inorden(arbolA.raiz);
            System.out.println();

            postorden(arbolA.raiz);
            System.out.println();

            System.out.println("Número de nodos: " + numeroNodos(arbolA));
            System.out.println("Altura del árbol: " + altura(arbolA));
            System.out.println("Grado del árbol: " + calcularGrado(arbolA));

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void preorden(NodoBinario nodo) {
        if (nodo != null) {
            System.out.print(nodo.dato);
            preorden(nodo.izq);
            preorden(nodo.der);
        }
    }

    public static void inorden(NodoBinario nodo) {
        if (nodo != null) {
            inorden(nodo.izq);
            System.out.print(nodo.dato);
            inorden(nodo.der);
        }
    }

    public static void postorden(NodoBinario nodo) {
        if (nodo != null) {
            postorden(nodo.izq);
            postorden(nodo.der);
            System.out.print(nodo.dato);
        }
    }

    public static int numeroNodos(ArbolBinario arbol) {
        return numeroNodos(arbol.raiz);
    }

    private static int numeroNodos(NodoBinario nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + numeroNodos(nodo.izq) + numeroNodos(nodo.der);
    }

    public static int altura(ArbolBinario arbol) {
        return altura(arbol.raiz);
    }

    private static int altura(NodoBinario nodo) {
        if (nodo == null) {
            return 0;
        }
        int alturaIzq = altura(nodo.izq);
        int alturaDer = altura(nodo.der);
        return 1 + Math.max(alturaIzq, alturaDer);
    }

    public static int calcularGrado(ArbolBinario arbol) {
        return calcularGrado(arbol.raiz);
    }

    private static int calcularGrado(NodoBinario nodo) {
        if (nodo == null) {
            return 0;
        }
        int grado = 0;
        if (nodo.izq != null) grado++;
        if (nodo.der != null) grado++;
        return Math.max(grado, Math.max(calcularGrado(nodo.izq), calcularGrado(nodo.der)));
    }
}