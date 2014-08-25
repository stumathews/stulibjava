<?xml version="1.0"?>
<!-- in2out.xsl -->

<xsl:stylesheet 
     xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
     version="1.0">     
   <xsl:output method="xml" indent="yes"/>
   
   <xsl:param name="third_stooge">Curly</xsl:param>
     
   <xsl:template match="/">         
      <xsl:comment> StoogesOut.xml </xsl:comment>  
      <xsl:element name="StoogesOut">
         <xsl:for-each select="//StoogeIn">
            <xsl:element name="StoogeOut">
            
               <xsl:choose>
                  <xsl:when test=".='Moe'">
                     <xsl:value-of select="."/>                     
                  </xsl:when>
                  <xsl:when test=".='Larry'">
                     <xsl:value-of select="."/>                     
                  </xsl:when>                  
                  <xsl:otherwise>
                     <xsl:value-of select="$third_stooge"/>                     
                  </xsl:otherwise>                  
               </xsl:choose>
               
            </xsl:element>
         </xsl:for-each>
      </xsl:element>
   </xsl:template>
   
</xsl:stylesheet>
