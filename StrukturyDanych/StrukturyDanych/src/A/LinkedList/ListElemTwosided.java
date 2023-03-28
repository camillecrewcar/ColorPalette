package A.LinkedList;

public class ListElemTwosided {
    public int value;              // Dana w elemencie listy (liczba calkowita)
    public ListElemTwosided next;          // Referencja do następnego elementu listy
    public ListElemTwosided previous;      /// Referencja do poprzedniego elementu listy

    public ListElemTwosided(int value) // konstruktor
    {
        this.value = value;   // Inicjalizacja danych
        next = null;
        previous = null;
    }

    public String toString()
    {
        return Integer.toString(value);
    }
}
