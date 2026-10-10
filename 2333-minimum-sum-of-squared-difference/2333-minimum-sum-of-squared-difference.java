class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n=nums1.length;
        int[]diff=new int[n];
        int maxdiff=0;
        for(int i=0;i<n;i++){
            diff[i]=Math.abs(nums1[i]-nums2[i]);
            if(diff[i]>maxdiff){
                maxdiff=diff[i];
            }
        }
        int[]bucket=new int[maxdiff+1];
        for(int a:diff){
            bucket[a]++;
        }
        long k=(long)k1+k2;
        for(int d=maxdiff;d>0;d--){
            if(bucket[d]==0){
                continue;
            }
            long count=bucket[d];
            if(k>=count){
                bucket[d-1]+=count;
                bucket[d]=0;
                k-=count;
            }
            else{
                bucket[d-1]+=k;
                bucket[d]-=k;
                k=0;
                break;
            }
        }
        long ans=0;
        for(int d=1;d<=maxdiff;d++){
            if(bucket[d]>0){
                ans+=(long)bucket[d]*d*d;
            }
        }
        return ans;
    }
}