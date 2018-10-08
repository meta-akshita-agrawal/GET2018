function Node(element,next){
    this.element=element;
    this.next = next;
}

function LinkedList(head,size){
    this.head=null;
    this.size=0;
this.add=function(element){
        var node = new Node(element);

        var current;

        if(this.head==null){
            this.head= node;
        }
        else{
            current = this.head;
            while(current.next){
                current = current.next;
            }

            current.next = node;
        }
        this.size++;
    }

    this.printList=function(){
        var current = this.head;
        var llString = "";
        while(current){
            llString += current.element + " ";
            current=current.next;
        }
        console.log(llString);
    }

    this.insertAt=function(element,index){

        if(index>this.size){
            console.log("index does not exist");
        }
        else{
            var newNode=new Node(element);
            var current, previous;

            current = this.head;

            
            var i =0;
            if(index == 0){
                newNode.next = head;
                this.head = newNode;
            }
            else{
                while(i<index){
                    i++;
                    previous = current;
                    current = current.next;
                }

                newNode.next =current;
                previous.next = newNode;
            }   
            this.size++;
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
            }
            this.size--;
        }

        return current.element;
    }
}