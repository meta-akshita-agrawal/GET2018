function Node(element,next,prev){
    this.element=element;
    this.next = next;
    this.prev = prev;
}

function doublyLinkedList(){
    this.head = null;
    this.size=0;

    this.add=function(element){
        var node = new Node(element);

        node.next = this.head;
        node.prev = null;

        if(this.head != null){
            this.head.prev = node;
        }
        this.head = node;

        this.size++;
    }

    this.printList= function(){

        var current = this.head;

        var llString="";
        while(current){
            llString += current.element + " ";
            current=current.next;
            
        }
        //console.log(previous.prev.element);
        console.log(llString);

    }

    this.addAtIndex=function(index,element){

        if(index>this.size){
            console.log("index does not exist");
        }
        else{
            var newNode=new Node(element);
            var current, previous;

            current = this.head;

            
            var i =0;
            if(index == 0){
                newNode.next = current;
                newNode.prev = null;
                this.head = newNode;
            }
            else{
                while(i<index){
                    i++;
                    previous = current;
                    current = current.next;
                }
                newNode.prev = previous;
                newNode.next =current;
                previous.next = newNode;
            }   
            this.size++;

            console.log(newNode.prev);
        }
    }

    this.delete=function(index){
        if(index>this.size){
            console.log("index does not exist");
        }
        else{
        
            var current,previous,i=0;

            current = this.head;
            if(index==0){
                this.head = null;
            }
            else{
                while(i<index){
                    i++;
                    previous = current;
                    current = current.next;
                }
                previous.next = current.next;
                previous.prev = current.prev;
            }
            this.size--;
        }

        return current.element;

    }
}