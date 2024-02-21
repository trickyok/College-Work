<?xml version="1.0" encoding="UTF-8"?>
<drawing version="7">
    <attr value="xc9500" name="DeviceFamilyName">
        <trait delete="all:0" />
        <trait editname="all:0" />
        <trait edittrait="all:0" />
    </attr>
    <netlist>
        <signal name="INPUT" />
        <signal name="PRE" />
        <signal name="CLK" />
        <signal name="Q0" />
        <signal name="Q1" />
        <signal name="RCO" />
        <signal name="XLXN_13" />
        <signal name="XLXN_24" />
        <signal name="XLXN_26" />
        <signal name="XLXN_27" />
        <signal name="XLXN_28" />
        <signal name="XLXN_29" />
        <signal name="XLXN_30" />
        <signal name="XLXN_31" />
        <signal name="XLXN_32" />
        <signal name="XLXN_33" />
        <signal name="XLXN_34" />
        <signal name="XLXN_35" />
        <signal name="XLXN_36" />
        <signal name="XLXN_37" />
        <signal name="XLXN_39" />
        <signal name="XLXN_40" />
        <signal name="XLXN_41" />
        <signal name="XLXN_42" />
        <signal name="XLXN_43" />
        <signal name="XLXN_44" />
        <signal name="XLXN_56" />
        <signal name="XLXN_57" />
        <signal name="XLXN_61" />
        <signal name="XLXN_62" />
        <signal name="XLXN_63" />
        <signal name="XLXN_67" />
        <signal name="XLXN_68" />
        <signal name="XLXN_44" />
        <signal name="XLXN_70" />
        <signal name="XLXN_72" />
        <signal name="XLXN_74" />
        <port polarity="Input" name="INPUT" />
        <port polarity="Input" name="PRE" />
        <port polarity="Input" name="CLK" />
        <port polarity="Output" name="Q0" />
        <port polarity="Output" name="Q1" />
        <port polarity="Output" name="RCO" />
        <blockdef name="ibuf">
            <timestamp>2000-1-1T10:10:10</timestamp>
            <line x2="64" y1="0" y2="-64" x1="64" />
            <line x2="64" y1="-32" y2="0" x1="128" />
            <line x2="128" y1="-64" y2="-32" x1="64" />
            <line x2="128" y1="-32" y2="-32" x1="224" />
            <line x2="64" y1="-32" y2="-32" x1="0" />
        </blockdef>
        <blockdef name="obuf">
            <timestamp>2000-1-1T10:10:10</timestamp>
            <line x2="64" y1="0" y2="-64" x1="64" />
            <line x2="64" y1="-32" y2="0" x1="128" />
            <line x2="128" y1="-64" y2="-32" x1="64" />
            <line x2="64" y1="-32" y2="-32" x1="0" />
            <line x2="128" y1="-32" y2="-32" x1="224" />
        </blockdef>
        <blockdef name="and2">
            <timestamp>2000-1-1T10:10:10</timestamp>
            <line x2="64" y1="-64" y2="-64" x1="0" />
            <line x2="64" y1="-128" y2="-128" x1="0" />
            <line x2="192" y1="-96" y2="-96" x1="256" />
            <arc ex="144" ey="-144" sx="144" sy="-48" r="48" cx="144" cy="-96" />
            <line x2="64" y1="-48" y2="-48" x1="144" />
            <line x2="144" y1="-144" y2="-144" x1="64" />
            <line x2="64" y1="-48" y2="-144" x1="64" />
        </blockdef>
        <blockdef name="inv">
            <timestamp>2000-1-1T10:10:10</timestamp>
            <line x2="64" y1="-32" y2="-32" x1="0" />
            <line x2="160" y1="-32" y2="-32" x1="224" />
            <line x2="128" y1="-64" y2="-32" x1="64" />
            <line x2="64" y1="-32" y2="0" x1="128" />
            <line x2="64" y1="0" y2="-64" x1="64" />
            <circle r="16" cx="144" cy="-32" />
        </blockdef>
        <blockdef name="or2">
            <timestamp>2000-1-1T10:10:10</timestamp>
            <line x2="64" y1="-64" y2="-64" x1="0" />
            <line x2="64" y1="-128" y2="-128" x1="0" />
            <line x2="192" y1="-96" y2="-96" x1="256" />
            <arc ex="192" ey="-96" sx="112" sy="-48" r="88" cx="116" cy="-136" />
            <arc ex="48" ey="-144" sx="48" sy="-48" r="56" cx="16" cy="-96" />
            <line x2="48" y1="-144" y2="-144" x1="112" />
            <arc ex="112" ey="-144" sx="192" sy="-96" r="88" cx="116" cy="-56" />
            <line x2="48" y1="-48" y2="-48" x1="112" />
        </blockdef>
        <blockdef name="fjkrse">
            <timestamp>2000-1-1T10:10:10</timestamp>
            <line x2="64" y1="-192" y2="-192" x1="0" />
            <line x2="64" y1="-416" y2="-416" x1="192" />
            <line x2="192" y1="-384" y2="-416" x1="192" />
            <line x2="64" y1="-32" y2="-32" x1="192" />
            <line x2="192" y1="-64" y2="-32" x1="192" />
            <line x2="64" y1="-128" y2="-144" x1="80" />
            <line x2="80" y1="-112" y2="-128" x1="64" />
            <rect width="256" x="64" y="-384" height="320" />
            <line x2="320" y1="-256" y2="-256" x1="384" />
            <line x2="64" y1="-416" y2="-416" x1="0" />
            <line x2="64" y1="-320" y2="-320" x1="0" />
            <line x2="64" y1="-32" y2="-32" x1="0" />
            <line x2="64" y1="-128" y2="-128" x1="0" />
            <line x2="64" y1="-256" y2="-256" x1="0" />
        </blockdef>
        <blockdef name="d3_8e">
            <timestamp>2000-1-1T10:10:10</timestamp>
            <line x2="64" y1="-576" y2="-576" x1="0" />
            <line x2="64" y1="-512" y2="-512" x1="0" />
            <line x2="64" y1="-448" y2="-448" x1="0" />
            <line x2="320" y1="-576" y2="-576" x1="384" />
            <line x2="320" y1="-512" y2="-512" x1="384" />
            <line x2="320" y1="-448" y2="-448" x1="384" />
            <line x2="320" y1="-384" y2="-384" x1="384" />
            <line x2="320" y1="-320" y2="-320" x1="384" />
            <line x2="320" y1="-256" y2="-256" x1="384" />
            <line x2="320" y1="-192" y2="-192" x1="384" />
            <line x2="320" y1="-128" y2="-128" x1="384" />
            <rect width="256" x="64" y="-640" height="576" />
            <line x2="64" y1="-128" y2="-128" x1="0" />
        </blockdef>
        <blockdef name="gnd">
            <timestamp>2000-1-1T10:10:10</timestamp>
            <line x2="64" y1="-128" y2="-96" x1="64" />
            <line x2="64" y1="-64" y2="-80" x1="64" />
            <line x2="40" y1="-64" y2="-64" x1="88" />
            <line x2="60" y1="-32" y2="-32" x1="68" />
            <line x2="52" y1="-48" y2="-48" x1="76" />
            <line x2="64" y1="-64" y2="-96" x1="64" />
        </blockdef>
        <blockdef name="vcc">
            <timestamp>2000-1-1T10:10:10</timestamp>
            <line x2="32" y1="-64" y2="-64" x1="96" />
            <line x2="64" y1="0" y2="-32" x1="64" />
            <line x2="64" y1="-32" y2="-64" x1="64" />
        </blockdef>
        <block symbolname="ibuf" name="XLXI_1">
            <blockpin signalname="INPUT" name="I" />
            <blockpin signalname="XLXN_44" name="O" />
        </block>
        <block symbolname="ibuf" name="XLXI_3">
            <blockpin signalname="CLK" name="I" />
            <blockpin signalname="XLXN_31" name="O" />
        </block>
        <block symbolname="ibuf" name="XLXI_2">
            <blockpin signalname="PRE" name="I" />
            <blockpin signalname="XLXN_34" name="O" />
        </block>
        <block symbolname="obuf" name="XLXI_4">
            <blockpin signalname="XLXN_39" name="I" />
            <blockpin signalname="Q0" name="O" />
        </block>
        <block symbolname="obuf" name="XLXI_6">
            <blockpin signalname="XLXN_43" name="I" />
            <blockpin signalname="RCO" name="O" />
        </block>
        <block symbolname="obuf" name="XLXI_5">
            <blockpin signalname="XLXN_44" name="I" />
            <blockpin signalname="Q1" name="O" />
        </block>
        <block symbolname="and2" name="XLXI_14">
            <blockpin signalname="XLXN_32" name="I0" />
            <blockpin signalname="XLXN_44" name="I1" />
            <blockpin signalname="XLXN_35" name="O" />
        </block>
        <block symbolname="and2" name="XLXI_15">
            <blockpin signalname="XLXN_33" name="I0" />
            <blockpin signalname="XLXN_24" name="I1" />
            <blockpin signalname="XLXN_34" name="O" />
        </block>
        <block symbolname="inv" name="XLXI_16">
            <blockpin signalname="XLXN_44" name="I" />
            <blockpin signalname="XLXN_24" name="O" />
        </block>
        <block symbolname="inv" name="XLXI_17">
            <blockpin signalname="XLXN_32" name="I" />
            <blockpin signalname="XLXN_33" name="O" />
        </block>
        <block symbolname="or2" name="XLXI_18">
            <blockpin signalname="XLXN_34" name="I0" />
            <blockpin signalname="XLXN_35" name="I1" />
            <blockpin signalname="XLXN_36" name="O" />
        </block>
        <block symbolname="fjkrse" name="XLXI_19">
            <blockpin signalname="XLXN_31" name="C" />
            <blockpin signalname="XLXN_63" name="CE" />
            <blockpin signalname="XLXN_44" name="J" />
            <blockpin signalname="XLXN_63" name="K" />
            <blockpin signalname="XLXN_62" name="R" />
            <blockpin signalname="XLXN_34" name="S" />
            <blockpin signalname="XLXN_32" name="Q" />
        </block>
        <block symbolname="fjkrse" name="XLXI_20">
            <blockpin signalname="XLXN_31" name="C" />
            <blockpin signalname="XLXN_67" name="CE" />
            <blockpin signalname="XLXN_36" name="J" />
            <blockpin signalname="XLXN_36" name="K" />
            <blockpin signalname="XLXN_61" name="R" />
            <blockpin signalname="XLXN_34" name="S" />
            <blockpin signalname="XLXN_39" name="Q" />
        </block>
        <block symbolname="d3_8e" name="XLXI_21">
            <blockpin signalname="XLXN_32" name="A0" />
            <blockpin signalname="XLXN_39" name="A1" />
            <blockpin signalname="XLXN_44" name="A2" />
            <blockpin signalname="XLXN_68" name="E" />
            <blockpin signalname="XLXN_41" name="D0" />
            <blockpin name="D1" />
            <blockpin name="D2" />
            <blockpin name="D3" />
            <blockpin name="D4" />
            <blockpin name="D5" />
            <blockpin name="D6" />
            <blockpin signalname="XLXN_42" name="D7" />
        </block>
        <block symbolname="or2" name="XLXI_22">
            <blockpin signalname="XLXN_42" name="I0" />
            <blockpin signalname="XLXN_41" name="I1" />
            <blockpin signalname="XLXN_43" name="O" />
        </block>
        <block symbolname="gnd" name="XLXI_23">
            <blockpin signalname="XLXN_62" name="G" />
        </block>
        <block symbolname="gnd" name="XLXI_24">
            <blockpin signalname="XLXN_61" name="G" />
        </block>
        <block symbolname="vcc" name="XLXI_25">
            <blockpin signalname="XLXN_63" name="P" />
        </block>
        <block symbolname="vcc" name="XLXI_26">
            <blockpin signalname="XLXN_68" name="P" />
        </block>
        <block symbolname="vcc" name="XLXI_27">
            <blockpin signalname="XLXN_67" name="P" />
        </block>
    </netlist>
    <sheet sheetnum="1" width="3520" height="2720">
        <branch name="INPUT">
            <wire x2="400" y1="560" y2="560" x1="240" />
        </branch>
        <branch name="PRE">
            <wire x2="400" y1="880" y2="880" x1="240" />
        </branch>
        <branch name="CLK">
            <wire x2="400" y1="1200" y2="1200" x1="240" />
        </branch>
        <instance x="400" y="592" name="XLXI_1" orien="R0" />
        <instance x="400" y="1232" name="XLXI_3" orien="R0" />
        <instance x="400" y="912" name="XLXI_2" orien="R0" />
        <iomarker fontsize="28" x="240" y="560" name="INPUT" orien="R180" />
        <iomarker fontsize="28" x="240" y="880" name="PRE" orien="R180" />
        <iomarker fontsize="28" x="240" y="1200" name="CLK" orien="R180" />
        <branch name="Q0">
            <wire x2="3152" y1="560" y2="560" x1="2992" />
        </branch>
        <branch name="Q1">
            <wire x2="3152" y1="864" y2="864" x1="2992" />
        </branch>
        <branch name="RCO">
            <wire x2="3152" y1="1248" y2="1248" x1="2992" />
        </branch>
        <instance x="2768" y="592" name="XLXI_4" orien="R0" />
        <iomarker fontsize="28" x="3152" y="560" name="Q0" orien="R0" />
        <instance x="2480" y="1344" name="XLXI_22" orien="R0" />
        <branch name="XLXN_31">
            <wire x2="704" y1="1200" y2="1200" x1="624" />
            <wire x2="1040" y1="1200" y2="1200" x1="704" />
            <wire x2="704" y1="656" y2="1200" x1="704" />
            <wire x2="2016" y1="656" y2="656" x1="704" />
        </branch>
        <branch name="XLXN_36">
            <wire x2="1904" y1="464" y2="464" x1="1840" />
            <wire x2="1904" y1="464" y2="528" x1="1904" />
            <wire x2="2016" y1="528" y2="528" x1="1904" />
            <wire x2="2016" y1="464" y2="464" x1="1904" />
        </branch>
        <branch name="XLXN_41">
            <wire x2="2464" y1="1040" y2="1040" x1="2048" />
            <wire x2="2464" y1="1040" y2="1216" x1="2464" />
            <wire x2="2480" y1="1216" y2="1216" x1="2464" />
        </branch>
        <branch name="XLXN_42">
            <wire x2="2464" y1="1488" y2="1488" x1="2048" />
            <wire x2="2480" y1="1280" y2="1280" x1="2464" />
            <wire x2="2464" y1="1280" y2="1488" x1="2464" />
        </branch>
        <branch name="XLXN_43">
            <wire x2="2768" y1="1248" y2="1248" x1="2736" />
        </branch>
        <branch name="XLXN_24">
            <wire x2="1136" y1="480" y2="480" x1="976" />
        </branch>
        <instance x="1136" y="608" name="XLXI_15" orien="R0" />
        <branch name="XLXN_33">
            <wire x2="1136" y1="544" y2="544" x1="976" />
        </branch>
        <instance x="752" y="576" name="XLXI_17" orien="R0" />
        <instance x="752" y="512" name="XLXI_16" orien="R0" />
        <instance x="1584" y="560" name="XLXI_18" orien="R0" />
        <branch name="XLXN_35">
            <wire x2="1568" y1="352" y2="352" x1="1392" />
            <wire x2="1568" y1="352" y2="432" x1="1568" />
            <wire x2="1584" y1="432" y2="432" x1="1568" />
        </branch>
        <branch name="XLXN_34">
            <wire x2="736" y1="880" y2="880" x1="624" />
            <wire x2="736" y1="880" y2="912" x1="736" />
            <wire x2="1040" y1="912" y2="912" x1="736" />
            <wire x2="1392" y1="800" y2="800" x1="736" />
            <wire x2="736" y1="800" y2="880" x1="736" />
            <wire x2="1392" y1="368" y2="496" x1="1392" />
            <wire x2="1392" y1="496" y2="512" x1="1392" />
            <wire x2="1392" y1="512" y2="800" x1="1392" />
            <wire x2="1584" y1="496" y2="496" x1="1392" />
            <wire x2="2016" y1="368" y2="368" x1="1392" />
        </branch>
        <branch name="XLXN_39">
            <wire x2="2576" y1="848" y2="848" x1="1600" />
            <wire x2="1600" y1="848" y2="1104" x1="1600" />
            <wire x2="1664" y1="1104" y2="1104" x1="1600" />
            <wire x2="2576" y1="528" y2="528" x1="2400" />
            <wire x2="2576" y1="528" y2="560" x1="2576" />
            <wire x2="2768" y1="560" y2="560" x1="2576" />
            <wire x2="2576" y1="560" y2="848" x1="2576" />
        </branch>
        <branch name="XLXN_32">
            <wire x2="1136" y1="384" y2="384" x1="640" />
            <wire x2="640" y1="384" y2="640" x1="640" />
            <wire x2="736" y1="640" y2="640" x1="640" />
            <wire x2="1520" y1="640" y2="640" x1="736" />
            <wire x2="1520" y1="640" y2="1040" x1="1520" />
            <wire x2="1520" y1="1040" y2="1072" x1="1520" />
            <wire x2="1664" y1="1040" y2="1040" x1="1520" />
            <wire x2="752" y1="544" y2="544" x1="736" />
            <wire x2="736" y1="544" y2="640" x1="736" />
            <wire x2="1520" y1="1072" y2="1072" x1="1424" />
        </branch>
        <instance x="1664" y="1616" name="XLXI_21" orien="R0" />
        <instance x="2768" y="1280" name="XLXI_6" orien="R0" />
        <iomarker fontsize="28" x="3152" y="1248" name="RCO" orien="R0" />
        <instance x="2768" y="896" name="XLXI_5" orien="R0" />
        <iomarker fontsize="28" x="3152" y="864" name="Q1" orien="R0" />
        <instance x="1136" y="448" name="XLXI_14" orien="R0" />
        <instance x="944" y="1440" name="XLXI_23" orien="R0" />
        <instance x="720" y="1120" name="XLXI_25" orien="R0" />
        <instance x="1040" y="1328" name="XLXI_19" orien="R0" />
        <branch name="XLXN_62">
            <wire x2="1040" y1="1296" y2="1296" x1="1008" />
            <wire x2="1008" y1="1296" y2="1312" x1="1008" />
        </branch>
        <branch name="XLXN_63">
            <wire x2="784" y1="1120" y2="1136" x1="784" />
            <wire x2="880" y1="1136" y2="1136" x1="784" />
            <wire x2="1040" y1="1136" y2="1136" x1="880" />
            <wire x2="1040" y1="1072" y2="1072" x1="880" />
            <wire x2="880" y1="1072" y2="1136" x1="880" />
        </branch>
        <branch name="XLXN_61">
            <wire x2="1552" y1="752" y2="768" x1="1552" />
            <wire x2="2016" y1="752" y2="752" x1="1552" />
        </branch>
        <instance x="1488" y="896" name="XLXI_24" orien="R0" />
        <instance x="2016" y="784" name="XLXI_20" orien="R0" />
        <instance x="1504" y="1424" name="XLXI_26" orien="R0" />
        <instance x="1792" y="592" name="XLXI_27" orien="R0" />
        <branch name="XLXN_67">
            <wire x2="2016" y1="592" y2="592" x1="1856" />
        </branch>
        <branch name="XLXN_68">
            <wire x2="1568" y1="1424" y2="1488" x1="1568" />
            <wire x2="1664" y1="1488" y2="1488" x1="1568" />
        </branch>
        <branch name="XLXN_44">
            <wire x2="656" y1="560" y2="560" x1="624" />
            <wire x2="656" y1="560" y2="832" x1="656" />
            <wire x2="1040" y1="832" y2="832" x1="656" />
            <wire x2="1040" y1="832" y2="1008" x1="1040" />
            <wire x2="1504" y1="832" y2="832" x1="1040" />
            <wire x2="1504" y1="832" y2="1136" x1="1504" />
            <wire x2="1648" y1="1136" y2="1136" x1="1504" />
            <wire x2="1648" y1="1136" y2="1168" x1="1648" />
            <wire x2="1664" y1="1168" y2="1168" x1="1648" />
            <wire x2="1136" y1="320" y2="320" x1="656" />
            <wire x2="656" y1="320" y2="480" x1="656" />
            <wire x2="656" y1="480" y2="560" x1="656" />
            <wire x2="752" y1="480" y2="480" x1="656" />
            <wire x2="2768" y1="864" y2="864" x1="1648" />
            <wire x2="1648" y1="864" y2="1136" x1="1648" />
        </branch>
    </sheet>
</drawing>