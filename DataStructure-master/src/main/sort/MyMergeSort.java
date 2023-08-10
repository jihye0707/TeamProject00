package main.sort;

import java.util.ArrayList;
import java.util.Comparator;

public class MyMergeSort {
    private ArrayList L1;
    private ArrayList L2;
    private Comparator comp;

    // Constructor
    public MyMergeSort(Comparator c) {
        L1 = new ArrayList();
        L2 = new ArrayList();
        comp = c;
    }

    // Implement the following methods
    public void sort(ArrayList l) {

        L1 = (ArrayList) l.clone();
        int d = 0;
        int cnt = 1;
        boolean flag = true; //true면 L1 -> L2 false면 L2-> L1

        while(cnt<l.size()){
            for(int i = 0; i<l.size(); i+=cnt*2){
                int start;
                int end;
                int mid;
                if(i+cnt*2>=l.size()){
                    start = i;
                    end = l.size()-1;
                    mid = (end-start+1)/2 + start;
                }
                else{
                    start = i;
                    end = i+cnt*2-1;
                    mid = (end-start+1)/2 + start;
                }

                if (flag){
                    merge(L1,L2,start,end,mid);
                }
                else{
                    merge(L2,L1,start,end,mid);
                }
            }
            if(flag) {
                flag = false;
                L1.clear();
            }
            else {
                flag = true;
                L2.clear();
            }
            d++;
            cnt = (int) Math.pow(2,d);
        }

        if (flag){
            merge(L1,L2,0,l.size()-1,(int) cnt/2);
            System.out.printf("정렬 후 =  ");
            System.out.println(L2);
        }
        else{
            merge(L2,L1,0,l.size()-1, (int) cnt/2);
            System.out.printf("정렬 후 =  ");
            System.out.println(L1);
        }
    }

    public void merge(ArrayList inputArr, ArrayList outputArr, int start, int end, int mid){
        int left = start;
        int right = mid;
        while (left<mid && right<=end){
            int rst = comp.compare(inputArr.get(left),inputArr.get(right));

            if(rst>0){
                outputArr.add(inputArr.get(left));
                left++;
            }
            else{
                outputArr.add(inputArr.get(right));
                right++;
            }
        }

        while(left<mid){
            outputArr.add(inputArr.get(left));
            left++;
        }

        while(right<=end){
            outputArr.add(inputArr.get(right));
            right++;
        }
    }

    public Comparator setComparator(Comparator c) {
        comp = c;
        return comp;
    }
}
