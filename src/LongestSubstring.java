
/**
 * 3. Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * 
 * @author Swin
 *
 */
public class LongestSubstring
{
// 未通过的方法
//	public int lengthOfLongestSubstrin1(String s) 
//	{
//		HashSet<Character> subString = new HashSet<Character>();
//		HashSet<Character> tmp = new HashSet<Character>();
//		for(int i = 0;i<s.length();++i)
//		{
//			if(!tmp.contains(s.charAt(i)))
//				tmp.add( s.charAt(i));
//			else 
//			{
//				tmp.remove(s.charAt(i));
//				tmp.add( s.charAt(i));
//			}
//			subString = tmp.size()>subString.size() ? new HashSet<Character>(tmp):subString;
//		}
//		return subString.size();
//	}

	public int lengthOfLongestSubstring(String s) 
	{
		int[] dict = new int[128];
		int ret=0, maxret=0, i;
		for(i=0;i<s.length();i++)
		{
			if(dict[s.charAt(i)]==0) 
				ret++;
			else{
				int tmp = i+1-dict[s.charAt(i)];//计算上个字符下个位置到现阶段该字符所在位置的距离，从上个重复字符的下个位置开始重新计算字串的长度
				if(ret>=tmp) 
					ret=tmp;//新的字串长度
				else 
					ret++;
			}
			dict[s.charAt(i)]=i+1;//更新重复的字符所在位置
			maxret = maxret<ret?ret:maxret;
		}
		return maxret;
	}

		public static void main(String[] args)
		{
			LongestSubstring ls = new LongestSubstring();
			String s = "qpxrjxkltzyz";
			int n= ls.lengthOfLongestSubstring(s);
			System.out.println(n);

		}

	}
