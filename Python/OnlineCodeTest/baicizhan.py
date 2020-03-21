st1 = input()
st2 = input()

dic1 = {0:"a",1:"b",2:"c",3:"d",4:"e",5:"f",6:"g",
        7:"h",8:"i",9:"j",10:"k",11:"l",12:"m",13:"n",
        14:"o",15:"p",16:"q",17:"r",18:"s",19:"t",20:"u",21:"v",
        22:"w",23:"x",24:"y",25:"z"}
dic2 = {j:i for i,j in dic1.items()}
N1 = len(st1)
N2 = len(st2)
count = 1
flag = 0
res = ''
while(count <=N1 or count <=N2 or flag):
    if count > N1:
        curword1 = "a"
    else:
        curword1 = st1[-count]
    if count > N2:
        curword2 = "a"
    else:
        curword2= st2[-count]
    tmp = dic2[curword1]+dic2[curword2]+flag
    flag =tmp //26
    tmpword = dic1[tmp%26]
    res += tmpword
    count += 1
print(res[::-1])