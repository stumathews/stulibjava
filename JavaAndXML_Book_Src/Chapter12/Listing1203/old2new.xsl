<?xml version="1.0"?>
<!-- old2new.xsl -->

<xsl:stylesheet 
     xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
     version="1.0">     
   <xsl:output method="xml" indent="yes"/>
     
   <xsl:template match="/">         
      <xsl:comment> NewData.xml </xsl:comment>
      <xsl:element name="NewData">
         <xsl:element name="LastName">
            <xsl:value-of select="//Name"/>
         </xsl:element>
         
         <xsl:element name="PostalCode">
            <xsl:value-of select="//Zip"/>
         </xsl:element>      
      </xsl:element>
   </xsl:template>
   
</xsl:stylesheet>
