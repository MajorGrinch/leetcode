class MovingAverage {
    
    int id, w;
    double[] sum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        id = 0;
        w = size;
        sum = new double[size+1];
        
    }
    
    int mod(int x){
        return x%(w+1);
    }
    
    public double next(int val) {
        id++;
        sum[mod(id)] = sum[mod(id-1)] + val;
        if( id < w ){
            return sum[id] / id;
        }else{
            return (sum[mod(id)] - sum[mod(id-w)]) / w;
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */