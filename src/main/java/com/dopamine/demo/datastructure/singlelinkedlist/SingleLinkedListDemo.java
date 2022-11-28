package com.dopamine.demo.datastructure.singlelinkedlist;

import lombok.Data;

import javax.xml.soap.Node;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author chenzi.ma
 * @since 2022/11/24
 * 使用实体类进行单链表模拟
 */
@Data
public class SingleLinkedListDemo {
    /**
     * 单链表需要有唯一的头节点，头节点序号0，默认无next
     */
    private NodeDemo headNode = new NodeDemo(0,null,"头节点");

    public SingleLinkedListDemo(){
        super();
    }

    public SingleLinkedListDemo(NodeDemo headNode) {
        this.headNode = headNode;
    }

    /**
     * 单链表添加方法 从头节点开始寻找，找到next为Null的数据为止，在当前数据上添加链表位置
     */
    public void add(NodeDemo nodeDemo){
        //从头节点开始
        NodeDemo temp = headNode;
        while (true){
            //当前节点的next为null,说明找到了尾节点，将参数赋值给尾节点即可
            if(temp.getNext() == null){
                if(nodeDemo.getNo() == 0){
                    nodeDemo.setNo(temp.getNo()+1);
                }
                temp.setNext(nodeDemo);
                break;
            }
            temp = temp.getNext();
        }
    }

    /**
     * 单链表插入方法：将数据插入到指定编号位置上
     */
    public void add(NodeDemo nodeDemo,int no){
        if(no ==0){
            System.out.println("链表首部禁止插入数据!");
            return;
        }
        //判断指定位置是否已有数据
        if(this.getByNo(no) != null){
            System.out.println("此出已有数据，无法插入!");
            return;
        }

        //获取编号最靠近no且比no小的数据。minNode的next指向新节点，新节点的next继承minNode的next节点
        NodeDemo minNode = getNearMin(no);
        nodeDemo.setNext(minNode.getNext());
        minNode.setNext(nodeDemo);
    }

    /**
     * 按no顺序插入单链表
     * @param nodeDemo
     */
    public void addByOrder(NodeDemo nodeDemo){
        int no = nodeDemo.getNo();
        this.add(nodeDemo,no);
    }

    /**
     * 获取当前编号相邻编号最小的数据
     * @return
     */
    public NodeDemo getNearMin(int no){
        //从头节点开始
        NodeDemo temp = headNode;
        while (temp!=null){
            if(temp.getNext() == null || temp.getNext().getNo() > no){
                return temp;
            }
            temp = temp.getNext();
        }
        return temp;
    }

    /**
     * 获取当前编号相邻编号最大的数据
     * @return
     */
    public NodeDemo getNearMax(int no){
        //从头节点开始
        NodeDemo temp = headNode;
        while (temp!=null){
            if(temp.getNo() >= no){
                return temp;
            }
            temp = temp.getNext();
        }
        return temp;
    }

    /**
     * 根据编号获取节点数据
     * @param no
     * @return
     */
    public NodeDemo getByNo(int no){
        //从头节点开始
        NodeDemo temp = headNode;
        while (true){
            if(temp == null || temp.getNo() == no){
                return temp;
            }
            temp = temp.getNext();
        }
    }

    /**
     * 根据传入的节点，修改对应节点的信息
     * @param nodeDemo
     */
    public void updateNode(NodeDemo nodeDemo){
        //获取传入节点的编号
        int no = nodeDemo.getNo();
        if(no == 0){
            System.out.println("头节点禁止修改");
            return;
        }
        //从头节点开始遍历
        NodeDemo temp = headNode.getNext();
        boolean result = false;
        while (temp!=null){
            if(temp.getNo() == no){
                result = true;
                temp.setName(nodeDemo.getName());
                break;
            }
            temp = temp.getNext();
        }
        if(!result){
            System.out.println("未发现需要修改的节点信息");
        }
    }

    /**
     * 根据编号删除
     * @param no
     */
    public void deleteNode(int no){
        if(no == 0){
            System.out.println("头节点禁止删除");
            return;
        }
        //从头节点开始遍历
        NodeDemo temp = headNode;
        boolean result = false;
        while (temp.getNext()!=null){
            if(temp.getNext().getNo() == no){
                result = true;
                temp.setNext(temp.getNext().getNext());
                break;
            }
            temp = temp.getNext();
        }

        if(!result){
            System.out.println("未发现需要删除的节点信息");
        }
    }

    /**
     * 获取有效节点个数
     * @return
     */
    public int countNode(){
        int count = 0;
        //从头节点开始遍历
        NodeDemo temp = headNode;
        while (temp.getNext()!=null){
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    /**
     * 获取单链表倒数第index节点
     * @param index
     * @return
     */
    public NodeDemo getNodeByDesc(int index){
        //获取单链表总有效节点数
        int count = this.countNode();
        if(count<index){
            System.out.println("该节点不存在");
            return null;
        }

        //目标节点是第count- index 个节点(从0开始计数)
        int target = count - index ;
        //从头节点后一位开始遍历
        NodeDemo temp = headNode.getNext();
        int i = 0;
        while (temp!=null){
            if(target == i){
                break;
            }
            i++;
            temp = temp.getNext();
        }
        return temp;
    }

    /**
     * 对单链表进行反转
     * @return
     */
    public void reversal(){
        if(headNode.getNext() == null || headNode.getNext().getNext() == null){
            System.out.println("无需反转");
            return;
        }
        NodeDemo reverHead = new NodeDemo(0,"头节点");

        NodeDemo temp = headNode.getNext();
        NodeDemo next = null;
        while (temp!=null){
            next = temp.getNext();
            temp.setNext(reverHead.getNext());
            reverHead.setNext(temp);
            temp = next;

        }
        headNode = reverHead;
    }

    /**
     * 反向遍历输出
     * @return
     */
    public String toStringReverse(){
        StringBuilder stringBuilder = new StringBuilder();
        NodeDemo temp = headNode;
        while (temp!=null){
            StringBuilder tempBuider = new StringBuilder(temp.toString());
            stringBuilder = tempBuider.append("<-").append(stringBuilder);
            temp = temp.getNext();
        }
        return stringBuilder.toString();
    }

    /**
     * 反向遍历输出(利用栈)
     * @return
     */
    public String toStringReverseStack(){
        StringBuilder stringBuilder = new StringBuilder();
        Stack<String> stack = new Stack<>();
        NodeDemo temp = headNode;
        while (temp!=null){
            stack.add(temp.toString());
            temp = temp.getNext();
        }
        while (stack.size()>0){
            stringBuilder.append(stack.pop()).append("<-");
        }
        return stringBuilder.toString();
    }

    /**
     * 将两个有序的链表合并为一个(暂不考虑no相同情况)
     * @param demo1
     * @param demo2
     * @return
     */
    public static SingleLinkedListDemo addAll(SingleLinkedListDemo demo1,SingleLinkedListDemo demo2){
        NodeDemo temp1 = demo1.getHeadNode().getNext();
        NodeDemo temp2 = demo2.getHeadNode().getNext();

        NodeDemo res = new NodeDemo(0,null,"首节点");
        NodeDemo temp = res;

        while (temp1!=null && temp2!=null){
            int no1 = temp1.getNo();
            int no2 = temp2.getNo();
            if(no1 < no2){
                temp.setNext(temp1);
                temp1 = temp1.getNext();
                temp = temp.getNext();
            }else {
                temp.setNext(temp2);
                temp2 = temp2.getNext();
                temp = temp.getNext();
            }
        }
        if(temp1 == null && temp2!=null){
            temp.setNext(temp2);
        }
        if(temp2 == null && temp1!=null){
            temp.setNext(temp1);
        }

        return new SingleLinkedListDemo(res);
    }

    @Override
    public String toString() {
        //从头节点开始
        NodeDemo temp = headNode;
        StringBuilder stringBuilder = new StringBuilder("当前链表输出为:");
        while (temp != null){
            stringBuilder.append("[no=").append(temp.getNo()).append(",name=").append(temp.getName()).append("]->");
            temp = temp.getNext();
        }
        return stringBuilder.toString();
    }


    /**
     * 测试方法
     */
    public static void main(String[] args) {
        SingleLinkedListDemo singleLinkedList = new SingleLinkedListDemo();
        System.out.println(singleLinkedList.toString());
        System.out.println("此时有效节点个数为:"+singleLinkedList.countNode());
        singleLinkedList.add(new NodeDemo(2,null,"2号节点"));
        singleLinkedList.add(new NodeDemo(4,null,"4号节点"));
        singleLinkedList.add(new NodeDemo(5,null,"5号节点"));
        System.out.println(singleLinkedList.toString());
        System.out.println("此时离3号最近的最小号是"+singleLinkedList.getNearMin(3).toString());
        System.out.println("此时离3号最近的最大号是"+singleLinkedList.getNearMax(3).toString());
        singleLinkedList.add(new NodeDemo(3,null,"3号节点"),3);
        System.out.println("插入3号位置之后，链表输出为:"+singleLinkedList.toString());
        System.out.println("此时离6号最近的最小号是"+singleLinkedList.getNearMin(6).toString());
        System.out.println("此时离6号最近的最大号是"+singleLinkedList.getNearMax(6));
        singleLinkedList.add(new NodeDemo(6,null,"6号节点"),6);
        System.out.println(singleLinkedList.toString());
        System.out.println("此时离1号最近的最小号是"+singleLinkedList.getNearMin(1).toString());
        System.out.println("此时离1号最近的最大号是"+singleLinkedList.getNearMax(1).toString());
        singleLinkedList.addByOrder(new NodeDemo(1,null,"1号节点"));
        System.out.println(singleLinkedList.toString());
        singleLinkedList.addByOrder(new NodeDemo(1,null,"1号节点"));
        singleLinkedList.updateNode(new NodeDemo(1,"1号节点-修改后"));
        System.out.println(singleLinkedList.toString());
        singleLinkedList.updateNode(new NodeDemo(7,"7号节点-修改后"));
        singleLinkedList.deleteNode(1);
        System.out.println(singleLinkedList.toString());
        singleLinkedList.deleteNode(3);
        System.out.println(singleLinkedList.toString());
        singleLinkedList.deleteNode(6);
        System.out.println(singleLinkedList.toString());
        singleLinkedList.deleteNode(7);
        System.out.println("此时有效节点个数为:"+singleLinkedList.countNode());
        System.out.println("此时倒数第一个节点为："+singleLinkedList.getNodeByDesc(1));
        System.out.println("此时倒数第二个节点为："+singleLinkedList.getNodeByDesc(2));
        System.out.println("此时倒数第三个节点为："+singleLinkedList.getNodeByDesc(3));
        System.out.println("此时倒数第四个节点为："+singleLinkedList.getNodeByDesc(4));
        singleLinkedList.reversal();
        System.out.println("反转后的单链表为:"+singleLinkedList.toString());
        singleLinkedList.reversal();
        System.out.println("反转回来的单链表为:"+singleLinkedList.toString());
        System.out.println("反向输出的单链表为:"+singleLinkedList.toStringReverse());
        System.out.println("使用栈反向输出的单链表为:"+singleLinkedList.toStringReverseStack());

        SingleLinkedListDemo demo1 = new SingleLinkedListDemo();
        demo1.add(new NodeDemo(3,new NodeDemo(5,new NodeDemo(9,null,"9号节点"),"5号节点"),"3号节点"));
        SingleLinkedListDemo demo2 = new SingleLinkedListDemo();
        demo2.add(new NodeDemo(1,new NodeDemo(2,new NodeDemo(4,new NodeDemo(11,null,"11号节点"),"4号节点"),"2号节点"),"1号节点"));
        System.out.println("合并后的单链表为:"+SingleLinkedListDemo.addAll(demo1,demo2).toString());
    }
}


