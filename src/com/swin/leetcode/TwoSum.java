package com.swin.leetcode;

import java.util.HashMap;

/**
 * 1. Two Sum
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * @author Swin
 * 使用hashmap的算法复杂度为O（n）
 */
public class TwoSum
{
	public int[] twoSum(int[] nums, int target) 
	{
        int [] res = new int [2];
        if(nums.length == 0)
        	return res;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
       
        for(int i=0;i<nums.length;++i)
        {
        	if(map.containsKey(nums[i]))
        	{
        		res[0] = map.get(nums[i]);
        		res[1] = i;
        	}
        	else 
        	{
				map.put(target-nums[i], i);
			}
        }
        return res;
    }	
	
	public static void main(String[] args)
	{
       int [] nums = {2, 7, 11, 15};
       int target = 9;
       TwoSum ts = new TwoSum();
       int [] res = ts.twoSum(nums,target);
       for(int i = 0;i<res.length;++i)
       {
           System.out.println(res[i]);
       }
	}

}
