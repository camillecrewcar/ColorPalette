package B;

import java.util.LinkedList;

public class TwosidedList {
    private LinkedList<Object> oList;

    public TwosidedList()
    {
        oList = new LinkedList<Object>();
    }

    public boolean isEmpty()
    {
        return oList.isEmpty();
    }

    public void insertFirst(Object elem)
    {
        oList.addFirst(elem);
    }

    public void insertLast(Object elem)
    {
        oList.addLast(elem);
    }

    public Object deleteFirst()
    {
        return oList.removeFirst();
    }

    public Object deleteLast()
    {
        return oList.removeLast();
    }

    public Object getFirst()
    {
        return oList.getFirst();
    }

    public Object getLast()
    {
        return oList.getLast();
    }

    public int size()
    {
        return oList.size();
    }

    public void print()
    {
        for (int i = 0; i < oList.size(); i++)
        {
            System.out.print(oList.get(i)+" ");
        }
        System.out.println();
    }
}
