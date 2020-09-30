#include<bits/stdc++.h>
using namespace std;

/*****************************************
    This program takes three inputs
    and calculates (a^b mod m) in optimized 
    time complexity of O(log b)

******************************************/

long long binpow(long long a, long long b, long long m) {

    long long res=1;

    while(b>0){

        if(b&1){
            res = ((res%m) * (a%m))%m;
        }
        
        a = ((a%m) * (a%m))%m; 
        b>>=1;
    }

    return res;
}


int main(){
	long long int a, b, m;
	cin >> a >> b >> m;
    cout << binpow(a, b, m);
}