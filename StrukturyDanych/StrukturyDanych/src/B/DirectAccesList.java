package B;

import java.util.ArrayList;

public class DirectAccesList {
    private ArrayList<Object> oList;

    public DirectAccesList()
    {
        oList = new ArrayList<Object>();
    }

    public boolean addLast(Object elem)
    {
        return oList.add(elem);
    }

    public Object removeLast()
    {
        int lastIndex = oList.size()-1;
        return oList.remove(lastIndex);
    }

    public Object get(int index)
    {
        return oList.get(index);
    }

    public int find(Object elem)
    {
        return oList.indexOf(elem);
    }

    public int size()
    {
        return oList.size();
    }

    public void print()
    {
        for (Object o : oList) {
            System.out.print(o + " ");
        }

        System.out.println("");
    }
}
