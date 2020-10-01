import java.io.*;
import java.util.*;
class TrieNode
{
    char value;
    boolean end;
    HashMap<Character, TrieNode>children;
    String word;
    TrieNode(char ch)
    {
        this.value = ch;
        this.children = new HashMap<>();
        this.end=false;
        this.word = null;
    }
}
class Trie {

    /** Initialize your data structure here. */
    TrieNode head;
    public Trie() {
        this.head = new TrieNode('*');
    }

    /** Inserts a word into the trie. */
    /** Complexity:O(n) where n is length of string to add */
    public void insert(String word) {
        TrieNode current = this.head;
        for (int pos = 0; pos < word.length(); pos++) {
            char ch = word.charAt(pos);
            if (!current.children.containsKey(ch))
                current.children.put(ch,new TrieNode(ch));
            current = current.children.get(ch);
        }
        current.end = true;
        current.word = word;
    }

    /** Returns if the word is in the trie. */
    /** Complexity: O(n) where n is length of string to search*/
    public boolean search(String word) {
        boolean exists = true;
        TrieNode current = this.head;
        for (int pos = 0; pos < word.length(); pos++) {
            char ch = word.charAt(pos);
            if (!current.children.containsKey(ch))
            {
                exists = false;
                break;
            }
            current = current.children.get(ch);
        }
        if (!exists)
            return false;
        else
            return current.end;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    /** Complexity: O(n) where n is length of prefix to search */
    public boolean startsWith(String prefix) {
        boolean exists = true;
        TrieNode current = this.head;
        for (int pos = 0; pos < prefix.length(); pos++) {
            char ch = prefix.charAt(pos);
            if (!current.children.containsKey(ch))
            {
                exists = false;
                break;
            }
            current = current.children.get(ch);
        }

        return exists;
    }
}
