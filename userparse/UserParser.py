import json
import string
import os

path = "./logs"
result_path = "./result"
file_list = os.listdir(path)

for logfile in file_list:
    f = open(path+"/"+logfile,'r',encoding = "utf-8")
    rf = open(result_path+"/"+logfile,'w',encoding = "utf-8")

    while True:	
        line = f.readline()
        if not line: break
        if line.find('data\":[{\"userNm') > 0:
            data = line.find("data") #json 위치 찾음
            jsonUser = line[data+7:-3]
            datadict = json.loads(jsonUser) #json 형식 dictionary로 저장
            datalist = list(datadict.values()) #value만 추출
            datalist[3]='1' #int 문자열로 교체
            if datalist[1] is None: datalist[1]='0' #학년이 null인경우 0으로 치환
           
            if datalist[9] == '외부연구원':
                index = 2
                while index <= 10:
                    if datalist[index] is None: datalist[index]='0'
                    index = index + 1

            rf.write(','.join(datalist)+"\n")
            #print(','.join(datalist))

    f.close()
    rf.close()
    




