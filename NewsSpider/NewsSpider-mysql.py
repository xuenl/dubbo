# -*- coding: utf-8 -*-
import os
import sys
import urllib2
import requests
import re
from lxml import etree
import MySQLdb

def StringListSave(slist):
   # 打开数据库连接
    db = MySQLdb.connect("localhost","root","1234","dubbo",charset="utf8")
    # 使用cursor()方法获取操作游标 
    cursor = db.cursor()
    # SQL 插入语句
    try:
        for s in slist:
            sql =  "INSERT INTO netEaseNews(title, url) VALUES ('" + s[0].encode("utf8") + "','" + s[1].encode("utf8") +"');"
            print sql
            cursor.execute(sql)
            # 提交到数据库执行
            db.commit()
    except:
       # Rollback in case there is any error
       db.rollback()
    # 关闭数据库连接
    db.close()
def Page_Info(myPage):
    '''Regex'''
    mypage_Info = re.findall(r'<div class="titleBar" id=".*?"><h2>(.*?)</h2><div class="more"><a href="(.*?)">.*?</a></div></div>', myPage, re.S)
    return mypage_Info

def New_Page_Info(new_page):
    '''Regex(slowly) or Xpath(fast)'''
    # new_page_Info = re.findall(r'<td class=".*?">.*?<a href="(.*?)\.html".*?>(.*?)</a></td>', new_page, re.S)
    # # new_page_Info = re.findall(r'<td class=".*?">.*?<a href="(.*?)">(.*?)</a></td>', new_page, re.S) # bugs
    # results = []
    # for url, item in new_page_Info:
    #     results.append((item, url+".html"))
    # return results
    dom = etree.HTML(new_page)
    new_items = dom.xpath('//tr/td/a/text()')
    new_urls = dom.xpath('//tr/td/a/@href')
    assert(len(new_items) == len(new_urls))
    return zip(new_items, new_urls)

def Spider(url):
    print "downloading ", url
    myPage = requests.get(url).content.decode("gbk")
    # myPage = urllib2.urlopen(url).read().decode("gbk")
    myPageResults = Page_Info(myPage)
    StringListSave(myPageResults)
    for item, url in myPageResults:
        print "downloading ", url
        new_page = requests.get(url).content.decode("gbk")
        # new_page = urllib2.urlopen(url).read().decode("gbk")
        newPageResults = New_Page_Info(new_page)
        StringListSave(newPageResults)


if __name__ == '__main__':
    print "start"
    start_url = "http://news.163.com/rank/"
    Spider(start_url)
    print "end"
