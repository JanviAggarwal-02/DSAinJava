package recursionandbacktracking;
class Solution {
    public double myPow(double x, int n) {
        long power=n;
        if(power<0){
            x=1/x;
            power=-power;
        }
        return solve(x,power);
        }
    
    public double solve(double x,long n){
        if(n==0) return 1;
        double h=solve(x,n/2);
        if(n%2==0) return h*h;
        return x*h*h;
    }
}