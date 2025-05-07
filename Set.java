public class Set{
    int _size;
    int[] intArray;

    public Set(int size) {
        this._size = size;
        intArray = new int[_size];
    }

    public void displaySet(){
        for (int i = 0; i < _size; i++) {
            if (intArray[i] != 0) System.out.print(intArray[i] + " ");
        }
        System.out.println();
    }

    public boolean isEmpty(){
        boolean empty = true;
        for (int i = 0; i < _size; i++) {
            if (intArray[i] > 0){
                empty = false;
                break;
            }
        }
        return empty;
    }

    public boolean hasElement(int goal){
        boolean hasele = false;
        for (int i = 0; i < _size; i++){
            if (intArray[i] == goal){
                hasele = true;
                break;
            }
        }
        return hasele;
    }

    public int add(int goal){
        int addIndex = -1;
        if (this.hasElement(goal)){
            //System.out.println("This integers has been in set.");
            return addIndex;
        }

        // If goal is not in set, add it into location which is 0
        for (int i = 0; i < _size; i++) {
            if (intArray[i] == 0) {
                intArray[i] = goal;
                addIndex = i;
                break;
            }
        }
        
        return addIndex;
    }

    public void removeItem(int n){
        if(isEmpty()){
            return;
        }
        if(!hasElement(n)){
            return;
        }
        for(int i= 0; i< intArray.length; i++){
            if(intArray[i] == n){
                for(int j = i; j < intArray.length - 1; j++){
                    intArray[j] = intArray[j+1];
                }
                intArray[intArray.length-1] = 0;
                return;
            }
        }
    }

    public boolean isSubset(Set goal){
        if (goal.isEmpty()) return true;
        for (int i = 0; i < goal._size; i++){
            if (!hasElement(goal.intArray[i])){
                return false;
            }
        }
        return true;
    }

    public boolean isEqual(Set goal){
        if (this.isEmpty() && goal.isEmpty()){
            return true;
        }
        if (this.isSubset(goal) && goal.isSubset(this)){
            return true;
        }

        return false;
    }

    public Set union(Set goal){
        Set new_set = new Set(this._size + goal._size);

        if (this.isEmpty() && goal.isEmpty()) return new_set;
        else if (this.isEmpty() && !goal.isEmpty()) new_set = goal;
        else if (!this.isEmpty() && goal.isEmpty()) new_set = this;
        else{
            for (int i = 0; i < this._size; i++){
                if (!new_set.hasElement(this.intArray[i])) new_set.add(this.intArray[i]);
            }
            for (int i = 0; i < goal._size; i++){
                if (!new_set.hasElement(goal.intArray[i])) new_set.add(goal.intArray[i]);
            }
        }

        return new_set;
    }

    public Set intersection(Set goal){
        Set new_set = new Set(this._size + goal._size);

        for (int i = 0; i < this._size; i++){
            if (goal.hasElement(this.intArray[i])){
                new_set.add(this.intArray[i]);
            }
        }

        return new_set;
    }

    public Set difference(Set goal){
        Set new_set = new Set(this._size + goal._size);

        for (int i = 0; i < this._size; i++){
            if (!goal.hasElement(this.intArray[i])) new_set.add(this.intArray[i]);
        }

        return new_set;
    }

    public Set symmetricDifference(Set goal){
        return this.union(goal).difference(this.intersection(goal));
    }
}
