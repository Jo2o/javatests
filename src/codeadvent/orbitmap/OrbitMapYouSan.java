package codeadvent.orbitmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrbitMapYouSan {

    private static Node found;
//    private static int pathYou = 0;
//    private static int pathSan = 0;

    public static void main(String[] args) {


        List<String> orbitMap = Arrays.asList("YMK)12Q","N3N)11S","P73)8Q3","PC8)14H","CDH)SR2","Z3F)KJF","3QM)NMC","GYV)H9S","7WN)TSD","GJ5)PXT","YSX)QT6","S74)HHH","2SG)Q63","N81)FGV","6V4)4VC","V12)HTX","SBY)WP6","22S)4JY","18W)CDB","8J6)3YS","BNS)X8W","L9V)N4T","JYL)R3X","941)5N8","8JL)JNJ","GVW)5LF","Z9K)H3K","G1T)MXH","11S)48W","4FX)8BD","NMN)YWJ","SY5)98H","MKT)44B","KNB)73D","GX4)BBP","V4P)8ZS","29S)3ZQ","X1H)MXF","FVC)16Q","TD1)79C","C2W)6HG","KHH)F82","D6R)PHM","C3H)K4T","6TR)NXG","RWV)17F","4ZW)FVY","5JQ)VDX","8XX)34J","VMX)HT3","JCY)X1H","4TN)8XX","QW6)8S9","Y78)87P","7BM)3Z9","8M3)396","RZ2)TLX","68P)41J","C72)3QM","J8D)61B","T3B)HTL","TC7)WQ1","676)CDW","7CW)J2Z","XYJ)68X","6VJ)RJH","CXC)R34","WQ2)WBW","1F2)X2X","QP1)JSJ","7KG)LL2","L63)TKM","RQ5)MV8","MGP)2V4","1LX)TYN","HJ6)LVP","3Z3)JB8","FQT)X7G","7XN)3VH","YWJ)TH8","787)8JV","TWJ)18L","MQT)3RG","XKP)YRQ","KJF)LRW","148)G7L","PR6)9JP","W5Q)GX4","JSJ)9HH","DKP)KXX","Z3Y)TRH","26K)8TS","VKP)XH6","Q9Q)3QH","1ZB)NWD","3KN)G92","64S)BJF","ZRT)KH5","N5M)VW9","142)RG1","V76)B1J","PBC)SY3","H8C)4SH","H78)7SR","2HP)R56","RGX)XB2","SKD)MFJ","7MV)4C5","X9H)LHQ","BBW)RFB","47F)X1V","3SP)DRJ","8KQ)5X5","ZHP)3NM","Z45)BKW","J87)RB4","748)7QG","X2R)QK8","6YN)SV1","6WP)83M","V68)NDS","49Q)SF1","L8D)XH1","HTQ)LWC","M9H)HFB","59W)K9T","FCT)ZTH","SF9)YTP","R63)L3J","SLX)WJD","4FY)YSN","TBR)QHK","615)V2V","B1J)4TN","XZV)GKX","8XX)CXC","FCT)S5M","YND)HTQ","HRC)Z39","Z4N)1TW","3ST)BYW","XHF)YGL","4JY)GVW","QNM)SBG","JVZ)TGZ","VB3)RB7","Z7M)MJL","KGG)Q8D","GYG)8FB","RRS)QF5","P7Y)LF3","MTG)GFJ","LHK)XP3","Z8V)VG3","Y9C)KK1","28L)26K","BX9)RMS","XB1)YQQ","PXF)9V6","4FR)J68","TMN)F2Y","MRX)N16","Y2Q)3QL","Z4Z)S8Y","3DT)VFM","751)L74","FKB)19W","X7B)J8D","C7K)7KG","R46)J37","QM2)FBW","FGS)NG8","PG1)91M","DRJ)175","S9Y)4LG","GX2)VF4","JT5)TQ2","87P)NVS","FLB)CT5","KK2)C3T","Y5J)BXF","S8X)XZ2","J7D)N5M","CLJ)TYC","794)YVG","YCP)DNZ","W9N)4NG","QK8)79Y","MQP)B3G","8F8)9J6","Z8D)PWT","WBW)98G","VX8)625","KSP)CHX","M5Q)J49","RMJ)QGQ","X6K)9T2","YC6)8VT","QT6)NB9","PC8)N38","FCD)2VQ","PCB)BB5","HXN)8C2","NF7)SKF","VV7)1H6","X1V)J4P","GSZ)DWX","QGQ)NKJ","CYV)9P7","94Y)YHV","RZY)JZ6","WXY)Q3L","RJC)T99","RWQ)KX7","RFQ)S6Q","QP1)BWD","KH5)NTV","DDJ)C8J","Z9L)RXZ","7M1)DH9","4JY)XQH","9TY)T59","P34)174","FM8)F25","76Q)81F","9WT)T33","8ZD)GQ7","MZW)1QC","HLW)YWR","H3K)1LX","L7F)1S6","SQB)5LJ","7VV)FXV","Q3L)QHT","34J)1Z3","P2P)FG9","15B)G52","KVS)YRX","5T7)NCC","TGZ)FRG","P7X)YOU","J37)MS5","DL4)DHS","PBH)HFV","KTD)ZHZ","GGH)FQJ","BJF)LWZ","R16)7VV","DQM)KG4","74Z)XYJ","11P)QT3","W1J)R42","Z1B)B8M","PD6)FQT","X1H)QD1","QGR)TX5","TDF)9TM","X11)9L1","P72)SZQ","CYT)1VW","PL9)FXW","HKD)8CP","F5L)G1T","KMV)YX9","1PS)GVG","DL7)W9N","M26)5QL","PLC)FCS","SY3)PZF","JPS)FVG","8BD)DZV","9MB)VCD","WS8)ZJG","9H6)2QY","HYQ)4N9","73D)HX4","6RB)QGV","MT2)GWN","12Q)NX7","KGB)9T4","XRD)M3T","P15)W5Q","JJ8)ZXJ","FXV)94Y","R1J)HTZ","1XP)7CW","ZZ1)X4S","KWG)WSN","RQK)Z9S","1M9)Z74","538)6CK","TN4)5T7","NXV)15S","8Q3)QZH","75N)YFS","VNN)LSC","NZS)L6V","LXN)FPQ","GYS)MZD","XM6)L66","LRG)KSP","CHX)Y7T","SLS)FFX","PP5)QZV","K8W)751","S1C)H2H","H93)WSY","175)ZTN","1F6)HLS","MVN)C79","N5T)LRM","W1P)VHN","G1C)N1W","GBJ)WWJ","KCN)8PX","QRH)6H2","1VW)GGX","J9N)RQL","J6B)YVT","BWD)VQR","JZ6)M4B","Q48)H4K","897)XJN","LSB)PPJ","5HK)KDQ","DL2)1TD","NSS)YVV","QVF)ZVV","BJF)WQ2","JTQ)62Q","765)N4P","H65)YMK","3JV)3NL","QQL)NZS","ZW2)V3C","FVC)97Z","ZSP)L71","J66)NTN","DY4)M2G","W5B)SKN","4G7)676","F21)C67","TCT)6FW","4TT)YR3","468)WXH","HDP)PG1","X79)NQK","S2J)BD6","2CG)SDJ","PZF)QFW","HX4)5JQ","SCP)CB8","XWJ)D47","CSX)V12","T99)B11","272)3F5","96V)M26","4SH)W3P","DF2)8N9","8CP)CWX","2T8)PF3","XH6)36Q","8N9)5XN","WXH)L6N","YZ8)L5W","6FW)GCH","S2V)CQP","Y11)WMK","Q48)F4X","N4P)ZHL","7HX)VLK","Q7Y)JRB","HL3)1ZD","ZQD)DKP","9H6)SAN","BB5)7BK","SKD)DYX","QDZ)ZK8","ZH6)1JC","GVT)P91","VLT)WXY","DH9)WDW","SP6)SSY","MTZ)GQ8","RJH)468","YC1)15B","FGV)MRX","8FB)LCW","F25)6Q4","424)SCL","WZG)JXW","396)XRX","JWC)F74","NZS)L75","C6B)9N9","34J)HKD","MZJ)LSF","S2T)4G7","X15)R16","ZH5)XPL","6VV)3ZK","55F)DDJ","PC6)4HG","N7B)897","V61)82Q","MS5)86B","16J)ZKZ","HVX)941","M2G)ZPB","PWC)NPH","FC1)Q48","9FZ)PVJ","R77)KRV","V6Q)SLS","5HB)6TR","3YS)2ZF","3TV)K9H","M18)QNM","3P6)GCC","SXM)6HS","4VD)T5N","6G1)H8H","7GG)R2D","5LJ)ZSP","6DB)NKT","B6T)73R","FH5)GVT","8SP)Z45","YSY)QQ7","9TM)MQP","2YZ)GT7","5X3)DF4","8TK)JLD","4N9)VKP","9T2)CNG","FDC)B6S","91X)TKQ","86H)HXZ","2TG)JPT","YVG)9JM","YTN)S95","RTD)C3H","625)73C","JRB)1XP","SX7)JWC","TSD)RP6","5X5)RSN","LLL)Y2Q","NQK)TSZ","H73)19D","C6B)ZQD","PPJ)VKR","FK4)XF9","XM2)2LK","67Z)95V","D3M)997","QFW)R1J","G1T)F37","KY9)R46","1RF)6RB","TDQ)34D","3QJ)MTR","VKR)49P","G57)DM1","Q73)TTR","LKY)6V4","B11)DPL","8QD)248","GFJ)MVN","MNQ)XRD","LXS)QXK","MFG)WD2","JTJ)3WX","2V4)8G5","H2T)3JC","MRD)QHM","HT5)JNP","HSZ)2Z2","YGL)QK7","SJF)VMX","X4Y)8K7","LGG)MJS","K8Q)VBQ","QT8)NSS","377)ZHP","SM6)MRD","XYL)YM4","3H8)LPT","6QH)B9M","QX5)9SB","F1S)9QR","42W)PKW","Z9S)QD2","R34)CLJ","KK1)Z23","XZ2)6VV","3VH)P2P","3F3)FGS","CWX)WWQ","JJ8)BFH","D5F)91Y","S15)2T8","GKD)1W1","GPD)6MM","2XH)Y77","4JH)R95","H8H)3KD","YF5)TG1","WCG)F63","67Z)9RD","73R)C7Z","B88)7BX","HHH)7B9","NKJ)ZPM","WLQ)JG2","P5Q)GHN","C3B)F46","8CL)26T","N4T)46R","YKT)89V","6RF)D3M","R2F)18W","X4H)DL4","XRX)FCD","YFC)WGZ","LRM)6RF","3CH)XQT","PVJ)SNV","H9M)H2V","15T)8QD","J68)RWV","XFH)VB3","GVW)9SQ","T8F)KFW","QT5)BXJ","K6C)3DZ","SBG)Y1X","N69)7HX","V86)314","GTJ)D6R","V3C)CJS","9S1)6GD","86B)X5L","P69)QRW","R8C)BWZ","FXD)1PM","TSG)Y78","G9G)4Y9","9LV)1F2","K66)YDF","RG1)F1X","VGL)3KN","RFB)Z4Z","66P)L6D","6G9)YFL","NWR)PD3","L6D)CB3","V5J)C6B","C67)3PJ","B6X)S9Y","9TY)JVZ","8ZS)H2T","J2Z)4JH","QHT)V87","8JV)PZP","VYM)K1M","WSY)YSH","C83)242","TDM)LR9","RRS)LJ2","VDX)GQ2","PLT)76Q","PBC)142","1QC)F1V","DSJ)SXF","YSK)S2T","KJF)QDZ","LSC)XT3","XKK)HRK","YRQ)SR9","Q39)449","216)K8Z","B16)RFZ","34N)G29","2ZF)H8N","S6Q)G4H","B75)X79","LRW)8J5","NCK)5B3","3DZ)RMW","MHM)22S","Y5N)88G","H4R)8NZ","6GB)R2P","97Y)Y37","X3G)F79","JJ1)6RW","HXZ)N5T","YFL)3P6","QMV)PBC","9RD)6DG","SDJ)16J","DNZ)7WN","MZD)J92","YSH)GX2","VNG)4DR","LPM)3YD","JB8)WZG","4T7)8RK","FQJ)FTT","ZPM)PRX","F46)LDN","PF3)LRZ","6RW)MNQ","9GN)CGW","LVP)N7D","VJS)P72","Y7R)N3N","DY4)1P1","CMQ)HX3","CB3)V5N","JJ6)58Y","ZXJ)W5B","4LH)7MV","DVN)34N","GD3)2BR","CVP)51P","CQP)KJW","LCB)Z9L","JZH)S67","K9T)MPT","L9J)Z6N","WRV)SRR","V9Y)5QH","J59)CGN","17F)DH2","B3G)VBC","TSH)JKN","H7L)9D8","6MV)7HT","BYK)MKT","V8V)WCG","COM)WLQ","939)Z42","BSS)459","TQ2)L9J","KSC)K6X","F37)K6Q","H9D)V5J","SBC)FWX","FNX)T3B","1WV)8Z5","MB5)CVY","TY5)794","PWT)QWS","XHC)RZ2","BFH)S15","S21)41Q","TP2)GDF","P91)M93","TBF)6QK","8HW)YSK","459)8D4","FWV)5JP","9CB)7HZ","WJL)FP7","RY6)T39","8D4)972","N38)PCB","SV1)R2F","JJQ)H3M","6YN)R6D","YGQ)H8K","5NV)LMY","7LV)CDH","12P)2TG","JBS)3JV","Q5P)V86","GFD)2X7","6FQ)2YZ","8NZ)BQP","8HG)3YK","RP6)MFP","7W2)SP6","T8Z)PC8","126)LQJ","2KK)Y11","BY5)VXS","FPQ)QP1","396)F9Y","4D9)4T7","29R)V9S","GBJ)VNF","ZBK)ZH5","QZV)4YL","GRV)3W4","3BT)PRQ","WSN)8X5","QZH)Y9G","VQR)YX3","KJ1)QX5","XXV)2XH","91Y)TCT","YQ3)X6K","M93)5HK","BQL)4VJ","R3X)HNW","9X1)TC7","298)V9Y","MFD)KNB","MFP)YTN","K8H)4D9","FWX)QGM","LF4)2WW","X6J)S54","J4P)FVC","PHQ)6WP","18R)QRH","3YD)NYX","73C)BW2","CB8)QHY","R6R)FWV","DS4)S1X","F9Y)ZRT","Z5M)H85","SR9)9LV","NK4)GQM","F87)9X1","8G5)YTH","9LV)7PN","5Y3)WSS","9JP)5T2","GHN)6NJ","G11)BGM","D8Y)PHQ","MGV)VRF","N7D)787","27Z)X6J","FFX)F3S","68X)67Z","MT2)XFH","YCZ)HX2","ZCX)25Q","CBK)ZBK","RBP)6GW","R6N)TY5","MTG)DL7","CFN)DL2","X7G)9C8","XQT)YFC","CWY)G7H","VF4)XKP","169)WSX","Z95)54H","ZHB)JX1","9JP)CVP","1P8)LPM","F7G)7QW","VBQ)291","XB2)8TL","5N8)HRL","3NL)7GR","R56)YFD","7BK)RGB","89V)LGG","TNF)86Z","H2H)HSZ","CT5)T5L","5KF)83R","SKN)XTV","HTX)SQV","9T4)5B9","4Z9)PD6","1ZD)HPG","PHP)DFB","31H)XDY","9KZ)47S","KW1)FCT","VW9)4QL","1KW)MHM","PRQ)V1B","D52)72Q","8Y1)21R","HT3)ZVN","LWC)748","3ZQ)84V","53F)Q83","YX3)BYK","4Y9)5SY","PLT)TKF","YFS)LSB","RMW)97Y","1W1)HJ6","SJN)28L","XYJ)8KQ","G86)X8Y","1GD)K2Y","ZPB)5DY","QQD)FKD","B8M)7YC","F4X)CVL","15S)MGP","B19)HK8","WG7)7XJ","JWF)7BM","86Z)126","QQ7)6YN","9GN)KZH","J52)HXN","GGM)68P","SVQ)LXS","F1V)B5L","7B9)YW5","3PP)YW3","RSP)Z3F","8K7)216","8F8)KGG","WRQ)GZM","91M)ZW2","VLK)LLL","Z6N)TDJ","FTT)T3H","CH5)KHH","GQM)T3Z","8C2)6F7","JG3)BDB","L75)J2C","1S8)ZN9","XDL)C2W","JX1)BBW","FG9)D5F","P2G)3NQ","2WW)SMS","9C8)CWY","3QX)7GJ","SG8)H9D","KFW)VD6","LWZ)BSS","SWY)K8H","F1X)Q5P","9SQ)J6B","WF6)F57","5SK)FXD","34D)41H","6DB)2LC","M9Z)4LH","FXR)KVS","9MJ)15P","B9F)9TY","M4L)QQL","Q63)PLC","6ZC)6VJ","N16)W1B","6SX)3QX","7WZ)N8H","974)K66","3BZ)FLB","T3Z)VLT","2DS)BQL","61B)SY5","TKQ)BFP","3NM)H6G","M25)N81","XKB)H32","ZXH)LJC","8Z5)KSC","5XN)6Z7","36Q)FXR","2LC)SJF","T1J)CYV","SWM)Z7M","RZ2)P34","Y9C)15T","MKW)SF8","J94)TN4","DV8)SWH","JJ1)DMS","BL1)4TS","ZCR)55F","G79)4PS","T5L)XWJ","BYW)B88","3D5)25D","CPZ)1GS","524)59W","J2C)Y9C","R13)R6N","9D8)1S7","ZVX)1ZB","VNS)ZZS","DM1)BNG","CVY)GTJ","GQ2)BL1","8HL)NSQ","PNS)96R","G4H)QFX","DFB)TDQ","S5M)PFD","TH8)SLX","BX6)XYL","V5F)LLF","41Q)1YG","1GP)SL7","W52)6G1","4C5)H8Z","KG4)86H","7GR)387","KNY)CQ1","HCJ)3JW","2K2)J87","916)LKY","RNL)YQM","WSS)3BZ","LH1)PR6","SWH)7TS","Z42)R4S","C2R)JJ1","GCH)TVW","B9F)8J6","9TW)9MJ","KDQ)QW6","ZFC)GXX","4ZM)T1R","VG3)PNS","DHS)LMX","5JZ)D9Z","YTP)8SX","S41)6FQ","1S7)KL9","YHV)W52","96R)RR6","YW5)54D","5CJ)3TV","RFZ)NMN","QF5)WF6","3TW)MTZ","DHD)KYT","2X7)SG8","YW5)RJC","NMC)8HG","74N)RNG","ZKZ)878","8HG)QVF","JYD)FK4","972)PQJ","248)TWN","SQV)P6Q","TLX)8J9","VCD)YCP","BDB)C72","7MV)C3B","QBG)GD3","F74)41K","2SV)5TL","TCR)GWQ","G7M)PXZ","ZVV)W1J","GX1)5CJ","N8H)WRV","25D)B75","MK9)YND","VFZ)M9Z","RH1)X4Y","FJW)BD2","M1V)GKD","41J)DY4","3ZK)MFG","TQQ)HPT","T84)5X3","KHR)MJ7","Q5L)NH7","YQM)5HB","4DR)9JS","JGL)8W3","Y7T)P7X","G6R)RL3","PXT)P4V","M18)M1V","YRX)FM8","84V)2CG","WD2)DYW","8J9)L72","R2V)PQG","64D)27Z","5KD)76Z","HPG)5JM","XP3)BX9","HPT)BX6","C7Z)5QP","ZJG)5SG","H2V)75N","H47)4WS","VCM)43R","5TJ)49Q","VRF)N43","T1R)PC6","HWT)B9F","16Q)Q39","HQF)3QJ","CLH)V61","25D)1M3","QQ1)LPQ","HPP)SN4","CQ1)DHD","XQH)SXM","W1B)RGX","4HG)YQ3","77Y)NF7","15P)K3H","FQ9)SF9","Y75)S2V","NVS)YKT","7HZ)X5X","8TT)F1S","PYC)PS7","WJQ)272","5B9)169","HZR)ZMY","7M1)5FK","665)CLH","S1X)HPP","S95)N3Y","LGF)KWG","NYX)Z5X","98G)R6R","WJD)K3T","YFD)XQF","Z23)4ZW","RSN)9H6","YWJ)PMD","M83)8M3","1TW)DSJ","RSP)LD3","XF3)XRN","JG2)HRC","DYX)SM6","FTB)9S1","83M)9JR","3NL)XPT","9V6)47F","D5K)SLV","BPP)M83","SY7)SX7","1LM)7GG","P8H)2CQ","3M3)4ZB","41K)3PP","KZH)9Q9","MZW)LCB","TG1)CBK","242)YSX","LRZ)PY6","TRH)RMJ","2NC)XWY","5QH)TH7","QNY)9WT","TSZ)JJQ","G7H)VFZ","Y51)ZCK","QGM)63Z","Q92)VNG","NX7)HL3","K2Y)NNM","CGW)N3F","CBK)YGQ","HL2)SJX","921)PLT","B1J)7XN","47S)Y51","PZP)FNX","DMS)H7L","KN8)MZW","DDF)X4H","4VQ)N3H","174)F7H","L72)6MV","XDR)CCR","WQ1)QGR","NSQ)7CN","PQJ)8B5","CDQ)GYT","YQQ)91X","5NZ)DF2","14H)8YB","7N9)MJW","3XT)JQM","5LD)TW3","4WS)ZVX","PWT)2KN","8S9)96V","ZHZ)1FJ","BC4)X6G","MGT)75P","HX3)Z8D","7CN)Y4J","C83)TQQ","PFD)R2V","H3M)PWC","8ZD)8F8","TYN)1GD","HFV)TDM","Y37)F21","XFD)5JF","Q9X)Z5V","YM4)VNN","MRG)HZR","GZV)Q7Y","GZM)3Z3","997)9MB","KL9)3M3","XTV)JT5","HTR)GFD","SLK)NB7","MPT)1M9","449)KN8","MJW)MTV","ZVN)7W2","21R)BD3","HK8)NCK","FBW)D41","L71)39K","YR3)Z8V","LSF)KK2","MTV)1F6","387)T84","6Q4)VJS","R2D)VPQ","DWX)3BT","KSV)6L7","CXK)GNT","81F)974","LDN)WRW","FRG)K8Q","54H)8L3","KXV)JGL","BXJ)765","CGN)179","72Q)J9N","W1S)XDR","41Q)ZCR","ZLH)MB5","RXZ)P2G","TYC)X7K","TYS)939","5T6)Y5N","QGR)TWJ","765)1RF","179)GBJ","HTZ)SVQ","2KV)XJD","MVZ)M4L","WP6)1QH","8X5)R63","QT3)R77","QQL)V8V","RR6)77Y","GXX)Y5J","6ZR)Z95","TWN)G57","ZZS)R8C","PMD)WS8","8TL)LB7","QHK)TYS","PMR)8JL","142)TCR","R95)ZFC","6HS)615","5TL)L7F","FP7)LKN","F79)X9H","XWY)4C2","SN4)DWH","1H6)KY9","7QW)XM6","C3T)9TS","XHT)GPX","Q83)GZV","7XJ)MVG","NKT)NKZ","2NX)3CH","T3H)KW1","YHY)K71","GDF)V7L","NLP)DF1","2LK)HDP","L66)V4P","NP9)W8B","49P)SQB","S67)Z1B","YDP)6ZC","7HT)PYY","GQ7)YST","Z39)FKB","QGV)JWF","86B)KXJ","TX5)VX8","V5N)GCW","7BX)JJ8","GT7)3F3","CNG)7M1","58Y)MTG","685)1FR","5SG)H8C","JXW)BZ4","XF9)QQD","CH5)F7G","1YG)KXV","BD2)F5L","NH7)3DT","LQJ)4VD","4ZB)12R","V7P)9FZ","TDJ)M5V","9SB)QBG","BPP)X11","ZKM)3XT","XFJ)54R","NG2)42W","G92)G7V","SJN)XHT","3KD)BLB","8W3)Z4Q","1M3)148","VYM)TSG","4TS)QT5","RFW)T8Z","WWQ)Z5M","TK8)C83","QWS)SY7","SYR)6G9","HNW)P15","PHM)74Z","D1L)FQ9","F82)8Y1","1P1)5LD","6F7)V9W","GPX)H47","MKF)JCY","V76)HL2","G2T)N9W","VPQ)B6X","ZMY)3L1","GCW)HLW","TW3)6DB","H7B)MFL","RQL)CV9","GKX)YF5","89B)3H8","9QR)YHY","K4T)SS1","SZM)GRV","SKF)D5K","6CK)1WV","8RK)8TT","6RB)T1J","X84)7N9","ZN9)9F4","N3F)P73","4V8)4M8","HRK)MKR","CJ4)7N5","HMK)XHF","928)ZT7","Y11)PBH","WMK)843","P73)2ZM","PQG)D8H","RFW)GX1","6GD)8ZD","298)4V8","3X8)CJ4","RR6)7SS","LPT)SJN","7BX)V76","LW2)2TK","DWH)D1L","KLR)XKB","2YZ)WG7","LPQ)FG1","D9Z)TJV","Y9G)XFJ","Z5X)8R6","5FK)M25","LCW)TXX","JKN)685","YTH)QS7","D47)MRG","QW4)9B6","7GJ)XFD","39K)RLD","Z74)5KD","1MD)JPS","8SX)VV7","N9V)V68","TDJ)G86","M9F)XMF","DYW)GGH","B9Z)KTD","HTZ)RY6","K9H)Q9Q","YVT)SYR","FKD)B42","R9N)48L","XPW)BPP","V7L)RFQ","X5X)VV5","XPL)H4R","2TK)WD6","XJD)N45","LV4)S2J","878)TJ4","T59)JYL","S8Y)3X8","ZJG)QM2","FBZ)J7D","3L1)S8X","TNF)35T","83X)BY5","3X8)921","BDD)KCN","TVW)TBR","9HH)CFN","P4V)KV6","BBP)Z5Q","WJ8)G79","KX7)SWY","6ZK)GF8","W3P)H7B","B42)LGF","R3K)J66","WD6)VGF","T5N)CDQ","1XP)1KW","H8N)G2T","BRF)ZCX","FXW)P8H","BGM)H73","QHM)MGV","V87)298","314)5PX","MJL)PR3","GXD)XM2","F7H)K44","JSP)62V","H8C)Z3Y","3RG)6ZK","L3J)DTX","JT5)T8F","XKG)N4S","HX2)XDL","DZV)ZJR","RLD)Q9B","Y1X)XHC","WQ4)JK8","BNG)SLK","LB7)LV4","35T)2NC","GCH)JTJ","K4V)D7G","LF3)7LV","HFB)GYS","4YL)2DS","VBC)SSR","SLV)ZHB","56P)LJ9","62Q)NBX","GYT)GXD","2Z2)CPZ","V61)CMQ","ZC5)RWQ","R9N)NXV","425)LRG","1Z3)Y75","TJV)BQ7","LLF)HCJ","CJS)425","K6Q)4K1","HTX)RNL","9KZ)7D7","FG1)DDF","1RF)FBZ","KXJ)CY9","4HT)J52","R95)B9Z","3NQ)JBS","PPJ)15N","SJX)P69","4PS)64D","H8K)2SV","6DG)5NZ","3Z9)12P","SL7)G1C","5QP)JYD","T39)SWM","95V)29S","NWD)LXN","G29)JTQ","8YB)424","LJ9)ZMG","VXS)WTB","YX9)4FR","WSX)85M","QBG)FJW","DLF)56P","QNM)YSY","9TS)SPR","J49)KGB","3QL)R13","K3T)J2T","PYY)4VQ","K5Y)MT2","RMS)3CM","ZJ8)NWR","V2V)VNS","TC7)89B","26T)5TN","JK8)YC7","P4V)L8S","44B)RQ5","8J5)WJQ","1S6)HVX","H87)7TF","3WX)RBP","RB7)LHK","MJ7)ZC5","2QY)CH5","25Q)1D2","K2Y)2KK","GGM)66P","97Z)YCZ","NTV)4FY","G49)G7M","SXF)8N6","MXF)DLF","T5L)6ZR","878)N7B","5B9)QJT","SZQ)3SP","C8J)XJC","N43)YZ8","9F4)DS4","75P)X3G","4LG)K9W","Z16)YC6","F3S)GYV","5KJ)TD1","9B6)CG3","LVP)DV8","XQF)HYQ","L6V)KJ1","Z5V)RRS","T33)Y7S","BFP)8BZ","7PN)VCM","4VQ)R9N","MVG)TBF","QFX)GYG","48W)9KZ","CG3)5TJ","X8Y)1MD","JPT)BC4","Y23)K7T","HTL)12M","B5L)MVZ","5LF)WQ4","5JF)MGB","VHN)C5Q","6H2)6GB","ZHL)MK9","FVG)NLP","QJT)RTD","3KS)Q1B","Z32)S74","SR2)MKW","K1M)ZZ1","H8Z)RFW","2VQ)ZXH","PCB)SKD","CDW)SBY","ZJR)53F","88G)TMN","DF1)PQ2","YC7)R3K","QKX)D52","BLB)MQT","LR9)1S8","8L3)M9F","C79)BRF","HLS)8SP","3QH)BDD","K6X)XB1","4QD)QNY","NPH)1GP","CMQ)QKX","GCC)K5Y","N3Y)H93","3YK)Z4N","928)VYM","6GW)Y7R","NKZ)HTR","D7G)T8N","RB4)KLR","H6G)FH5","2CQ)V14","X8W)ZH6","GVG)5SK","TX5)XXV","XH1)KHR","MFJ)H52","XMF)TCD","X5L)5KF","NG8)VGL","KV6)DVN","VNF)29R","WSG)8CL","85M)ZJ8","7D7)2SG","7SR)PXF","K8Q)GSZ","G7L)Z32","QRW)KQK","98H)H87","9JS)P7Y","KYY)BZ6","L6N)PYC","MFL)34L","BZ4)L9V","9RD)5T6","76Z)SHM","D8H)QW4","51P)BNS","DTX)F87","DJB)Q73","CY9)FC1","843)4XK","K7W)N69","18L)9CB","F57)Q92","FCS)WSG","SF8)TP2","8BZ)31H","Z4Q)QT8","PXZ)JS9","JLD)3TW","L8S)WJ8","3JW)XF3","2NR)83X","DVN)4TT","6L7)5Y3","X4S)C2R","K6Q)PL9","7TF)W87","7ZG)S41","LMX)57N","FPQ)CSX","4K1)WRQ","3PJ)M18","JQM)Q9X","3JN)X84","HRL)538","XDL)6SX","6QK)L63","1FJ)Q5L","TH7)SBC","K8Z)J59","GHN)524","F2Y)G9G","9JR)HQF","VGF)CYT","DPL)K4V","C5Q)TNF","X7K)W15","79Y)DJB","56P)XPW","BW2)X7B","9L1)5KJ","ZCK)3J5","H85)SZM","LKN)MZJ","SMS)GYD","ZTH)MKF","QHT)K8W","CVL)JJ6","X2X)7ZG","ZTN)S1C","N16)G11","3Z9)RZY","19D)H9M","48L)YC1","5QL)928","216)CXK","N45)8HL","VT6)4HT","XDY)GGM","W8B)Y23","JVZ)B16","MHM)QMV","XDR)1PS","19W)64S","TXX)2HP","BKW)P5Q","9J6)11P","43R)V5F","RGB)8TK","6NJ)V6Q","ZK8)665","9N9)H78","Y77)WJL","VJS)YDP","Z5Q)3ST","MXF)QQ1","JNP)ZKM","R6D)LH1","M4B)JSP","Y7S)V48","M5V)YKJ","3F5)NG2","5PX)Q2F","T8N)JG3","83R)C7K","VFM)C5V","3J5)KYY","W87)NK4","4C2)3KS","ML4)PHP","54D)H65","BQP)K7W","N4S)9GN","RRP)RH1","C3B)D8Y","L74)DQM","XWN)916","NDS)ZLH","1PM)4FX","PD3)GJ5","F3J)L8D","3CM)HT5","GNT)2K2","TKF)3D5","2T8)RRP","XJN)G6R","VV5)74N","1TD)XFK","V9S)KMV","2ZM)QPV","C7Z)1P8","41H)B6T","GWN)HMK","DF4)Q8Z","314)XWN","V1B)TFW","1D2)2PW","N4P)W1P","WWJ)1LM","GF8)HWT","K8Z)FTB","MJS)TK8","F63)TSH","CWY)SCP","4XK)Z16","TBF)2KV","1GS)DG9","NBX)XKK","LJ2)LF4","WDW)M5Q","NTN)XT1","WTB)3JN","8N6)W1S","N9W)377","QD1)V7P","6HG)RSP","7N5)18R","TSG)6JN","SPR)7WZ","QHY)TDF","H9S)4Z9","4M8)X2R","DRJ)PP5","MTR)5JZ","8B5)4ZM","TJ4)6QH","CCR)2NX","SF1)MFD","SS1)T4M","VD6)5NV","BQ7)XZV","ZT7)KSV","97Z)4QD","BBP)B19","6JN)J94","R42)RQK","MGP)JZH","V9S)KNY","5DY)PMR","FK4)8HW","4VJ)F3J","J92)2NR","XRN)Z9K","M83)NP9","787)G49","N1W)ML4","XJD)VT6","7SS)9TW","YST)S21","K71)X15","3W4)FDC","1FR)GPD","WRW)MGT","TRH)K6C","LL2)M9H","NNM)XKG","KXX)N9V","5CJ)LW2");

//        List<String> orbitMap = Arrays.asList("COM)B","B)C","C)D","D)E","E)F","B)G","G)H","D)I","E)J","J)K","K)L","K)YOU","I)SAN");

        Node tree = constructTree(orbitMap);

        found = null;
        Node you = search("YOU", tree);
        found = null;
        Node san = search("SAN", tree);

        List<String> com2you = getPathTo(you);
        List<String> com2san = getPathTo(san);

        String commonParent = commonParent(com2you, com2san);

        int youSteps = countSteps(you, commonParent);
        int sanSteps = countSteps(san, commonParent);

        System.out.println("Orbits to overcome: " + (youSteps + sanSteps - 2));

    }

    private static int countSteps(Node san, String commonParent) {
        int counter = 0;
        Node tmp = san;
        while (!tmp.getName().equals(commonParent)) {
            counter++;
            tmp = tmp.getParent();
        }
        return counter;
    }


    private static String commonParent(List<String> com2you, List<String> com2san) {
        for (String nameFromYou : com2you) {
            for (String nameFromSan : com2san) {
                if (nameFromYou.equals(nameFromSan)) {
                    System.out.println("Common you & san parent: " + nameFromSan);
                    return nameFromSan;
                }
            }
        }
        System.out.println("Common you & san parent not found!");
        return null;
    }

    private static List<String> getPathTo(Node node) {
        List<String> com2node = new ArrayList<>();
        while (node.getParent() != null) {
            com2node.add(node.getName());
            node = node.getParent();
        }
        return com2node;
    }

    private static Node search(String you, Node tree) {
        find(tree, you);
        return found;
    }

    private static void find(Node node, String name) {
        if (found != null) {
            return;
        }
        if (node.getChildren() == null || node.getChildren().isEmpty()) {
            return;
        }
        List<Node> children = node.getChildren();
        for (Node child : children) {
            if (child.getName().equals(name)) {
                found = child;
                return;
            } else {
                find(child, name);
            }
        }
    }







//    private static int countOrbits(Node tree) {
//        List<Node> leafs = new ArrayList<>();
//        getLeafs(tree, leafs);
//
//        Map<String, Node> allNodesMap = getAllNodes(leafs);
//        int total = 0;
//
//        List<Node> allNodes = new ArrayList<>();
//        for (Map.Entry<String,Node> entry : allNodesMap.entrySet()) {
//            System.out.println("Key = " + entry.getKey() +
//                    ", Value = " + entry.getValue());
//            allNodes.add(entry.getValue());
//        }
//
//        for (Node node : allNodesMap.values()) {
//            int pathsToRoot = countPathToRoot(node);
//            total += pathsToRoot;
//        }
//        return total;
//    }

//    private static Map<String, Node> getAllNodes(List<Node> leafs) {
//        Map<String, Node> allNodes = new HashMap<>();
//        for (Node leaf : leafs) {
//            Node temp = leaf;
//            while (temp.getParent() != null) {
//                if (allNodes.get(temp.getName()) == null) {
//                    allNodes.put(temp.getName(), temp);
//                }
//                temp = temp.getParent();
//            }
//        }
//        return allNodes;
//    }

    private static int countPathToRoot(Node leaf) {
        int result = 0;
        Node currentLeaf = leaf;
        while (currentLeaf.getParent() != null) {
            result++;
            currentLeaf = currentLeaf.getParent();
        }
        return result;
    }

//    private static void getLeafs(Node node, List<Node> leafs) {
//        if ((node.getChildren() == null) || node.getChildren().isEmpty()) {
//            leafs.add(node);
//            return;
//        }
//        List<Node> children = node.getChildren();
//        for (Node child : children) {
//            getLeafs(child, leafs);
//        }
//    }

    private static Node constructTree(List<String> orbitMap) {
        Map<String, Node> orbitTreeMap = new HashMap<>();
        Node root = null;
        for (String orbit : orbitMap) {
            String[] connection = orbit.split("\\)");
            Node child = orbitTreeMap.get(connection[1]);
            boolean isChildNew = false;
            if (child == null) {
                child = new Node(connection[1]);
                orbitTreeMap.put(connection[1], child);
                isChildNew = true;
            }
            Node parent = orbitTreeMap.get(connection[0]);
            if (parent == null) {
                parent = new Node(connection[0]);
                orbitTreeMap.put(connection[0], parent);
            }
            //if (isChildNew) {
                parent.addChild(child);
            //}
            if (connection[0].equals("COM")) {
                root = parent;
            }
        }
        return root;
    }

}
