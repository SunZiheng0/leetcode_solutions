package leetcode.graph.unionFind;
/*
721. Accounts Merge
Medium

Given a list accounts, each element accounts[i] is a list of strings,
where the first element accounts[i][0] is a name, and the rest of the elements
are emails representing emails of the account.

Now, we would like to merge these accounts. Two accounts definitely belong to the same
person if there is some email that is common to both accounts. Note that even if two
accounts have the same name, they may belong to different people as people could have the
same name. A person can have any number of accounts initially, but all of their accounts
definitely have the same name.

After merging the accounts, return the accounts in the following format: the first element
of each account is the name, and the rest of the elements are emails in sorted order. The
accounts themselves can be returned in any order.

Example 1:

Input:
accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"],
["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],
["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
Explanation:
The first and third John's are the same person as they have the common email "johnsmith@mail.com".
The second John and Mary are different people as none of their email addresses are used by
other accounts.
We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'],
['John', 'johnnybravo@mail.com'],
['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.

 */
import java.util.*;

public class AccountMerge {
    //my solution
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> owners = new HashMap<String, String>();
        for(List<String> account : accounts){
            owners.put(account.get(1), account.get(0));
        }
        //System.out.println(owners);
        Map<String, String> parents = new HashMap<String, String>();

        for(List<String> account : accounts){
            String p = account.get(1);           //每次使用parent的时候，都要判断是否为root，
                                                 // 用循环找到真正的parent
            if(parents.containsKey(p)){
                while(p != parents.get(p)) p = parents.get(p);
            }
            for(int i = 1; i < account.size(); i++){
                String curr = account.get(i);
                if(!parents.containsKey(curr)){
                    parents.put(curr, p);
                }else{
                    while(curr != parents.get(curr)) curr = parents.get(curr);
                    parents.put(curr, p);
                }
            }
            //System.out.println(parents);
        }
        //System.out.println(parents);

        Map<String, TreeSet<String>> unions = new HashMap<String, TreeSet<String>>();
        for(String key : parents.keySet()){
            String p = parents.get(key);
            while(p != parents.get(p)) p = parents.get(p); //找到真正的parent，直接取出的
                                                         // 并不是union的标识，要找到root
            if(!unions.containsKey(p)){
                TreeSet<String> set = new TreeSet<String>();
                set.add(key);
                unions.put(p, set);
            }else{
                unions.get(p).add(key);
            }
        }
        //System.out.println(unions);

        List<List<String>> result = new ArrayList<>();
        for(String p : unions.keySet()){
            List<String> l = new ArrayList<String>();
            l.add(owners.get(p));
            l.addAll(unions.get(p));
            result.add(l);
        }
        return result;
    }
}


