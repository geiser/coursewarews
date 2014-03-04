
#TASKS = createLDExerciseLearningObject
JAVA_PARAMS = -XX:+HeapDumpOnOutOfMemoryError -Xmx1024m

MYSQL = mysql
DBUSER = root
DBNAME = automatedldtest

LOG_FILE = common.log

JAVA_AUXS = build/$(TASK)/Reverse.java build/$(TASK)/DivideList.java \
	build/$(TASK)/ConcatList.java build/$(TASK)/Remove.java \
	build/$(TASK)/Length.java build/$(TASK)/Floor.java \
	build/$(TASK)/GetIndGoal.java build/$(TASK)/GetUUID.java \
	build/$(TASK)/Intersection.java build/$(TASK)/GetCLGrouping.java \
	build/$(TASK)/JSHOP2Provider.java build/$(TASK)/FilterByQuery.java \
	build/$(TASK)/GetElements.java build/$(TASK)/GetPropertyValue.java \
	build/$(TASK)/GetRelated.java build/$(TASK)/GetType.java \
	build/$(TASK)/BuildElement.java build/$(TASK)/Util.java \
	build/$(TASK)/GetDefaultValue.java build/$(TASK)/UUID.java \
	build/$(TASK)/ConcatText.java build/$(TASK)/Union.java \
	build/$(TASK)/GetProduct.java
        # build/$(TASK)/JSHOP2Provider.java \
	#build/$(TASK)/Intersection.java build/$(TASK)/GetUUID.java \
	#build/$(TASK)/Util.java build/$(TASK)/FilterByQuery.java \
	#build/$(TASK)/Remove.java build/$(TASK)/GetSetsByCount.java \
	#build/$(TASK)/Ceiling.java build/$(TASK)/CLGrouping.java \
	#build/$(TASK)/Length.java build/$(TASK)/Base64Encode.java \
	#build/$(TASK)/GetGMIPInfo.java build/$(TASK)/Floor.java \
	#build/$(TASK)/ConcatText.java build/$(TASK)/CLGroupingNew.java \
	#build/$(TASK)/CLGroupingTest.java build/$(TASK)/BuildElement.java \
	#build/$(TASK)/GetIndGoal.java

TEST_FILES = build/$(TASK)/p_l$(l)_c$(c)_g$(g)_a$(a)_$(d)_h$(h)_m$(m).lisp

LDPATH = $(CURDIR)/..
LIBS = $(LDPATH)/lib/jshop2cp.jar:$(LDPATH)/lib/jshop2rt.jar:$(LDPATH)/lib/antlr-2.7.6.jar:$(LDPATH)/lib/mysql-connector-java.jar


test_planner :
	#cp p_l256_g32.java build/createLDFundamentalUoL
	#make TASK="createLDFundamentalUoL" l="256" g="32" test
	make TASK="createLDFundamentalUoL" l="8" g="2" test

test_32 :
	cp src/p_l32_*.java build/createLDFundamentalUoL/
	make TASK="createLDFundamentalUoL" l="32" g="2" test
	make TASK="createLDFundamentalUoL" l="32" g="4" test
	make TASK="createLDFundamentalUoL" l="32" g="8" test
	make TASK="createLDFundamentalUoL" l="32" g="16" test
	make TASK="createLDFundamentalUoL" l="32" g="32" test

test_64 :
	cp src/p_l64_*.java build/createLDFundamentalUoL/
	make TASK="createLDFundamentalUoL" l="64" g="2" test
	make TASK="createLDFundamentalUoL" l="64" g="4" test
	make TASK="createLDFundamentalUoL" l="64" g="8" test
	make TASK="createLDFundamentalUoL" l="64" g="16" test
	#make TASK="createLDFundamentalUoL" l="64" g="32" test

test_128 :
	cp src/p_l128_*.java build/createLDFundamentalUoL/
	make TASK="createLDFundamentalUoL" l="128" g="2" test
	make TASK="createLDFundamentalUoL" l="128" g="4" test
	make TASK="createLDFundamentalUoL" l="128" g="8" test
	make TASK="createLDFundamentalUoL" l="128" g="16" test
	#make TASK="createLDFundamentalUoL" l="128" g="32" test

test_256 :
	#cp src/p_l256_*.java build/createLDFundamentalUoL/
	make TASK="createLDFundamentalUoL" l="256" g="2" test
	make TASK="createLDFundamentalUoL" l="256" g="4" test
	#make TASK="createLDFundamentalUoL" l="256" g="8" test
	#make TASK="createLDFundamentalUoL" l="256" g="16" test
	#make TASK="createLDFundamentalUoL" l="256" g="32" test

test_fundamental :
	#make TASK="createLDFundamentalUoL" l="$(l)" c="$(c)" g="$(g)" a="5" d="2" h="1" m="0" sql="-sql" test
	make TASK="createLDFundamentalUoL" l="32" c="$(c)" g="2" a="5" d="2" h="1" m="0" sql="-sql" test
	make TASK="createLDFundamentalUoL" l="32" c="$(c)" g="4" a="5" d="2" h="1" m="0" sql="-sql" test
	make TASK="createLDFundamentalUoL" l="32" c="$(c)" g="8" a="5" d="2" h="1" m="0" sql="-sql" test
	make TASK="createLDFundamentalUoL" l="32" c="$(c)" g="16" a="5" d="2" h="1" m="0" sql="-sql" test
	make TASK="createLDFundamentalUoL" l="32" c="$(c)" g="32" a="5" d="2" h="1" m="0" sql="-sql" test
	make TASK="createLDFundamentalUoL" l="64" c="$(c)" g="2" a="5" d="2" h="1" m="0" sql="-sql" test
	make TASK="createLDFundamentalUoL" l="64" c="$(c)" g="4" a="5" d="2" h="1" m="0" sql="-sql" test
	make TASK="createLDFundamentalUoL" l="64" c="$(c)" g="8" a="5" d="2" h="1" m="0" sql="-sql" test
	make TASK="createLDFundamentalUoL" l="64" c="$(c)" g="16" a="5" d="2" h="1" m="0" sql="-sql" test
	make TASK="createLDFundamentalUoL" l="64" c="$(c)" g="32" a="5" d="2" h="1" m="0" sql="-sql" test
	make TASK="createLDFundamentalUoL" l="128" c="$(c)" g="2" a="5" d="2" h="1" m="0" sql="-sql" test
	make TASK="createLDFundamentalUoL" l="128" c="$(c)" g="4" a="5" d="2" h="1" m="0" sql="-sql" test
	make TASK="createLDFundamentalUoL" l="128" c="$(c)" g="8" a="5" d="2" h="1" m="0" sql="-sql" test
	make TASK="createLDFundamentalUoL" l="128" c="$(c)" g="16" a="5" d="2" h="1" m="0" sql="-sql" test
	make TASK="createLDFundamentalUoL" l="128" c="$(c)" g="32" a="5" d="2" h="1" m="0" sql="-sql" test
	make TASK="createLDFundamentalUoL" l="256" c="$(c)" g="2" a="5" d="2" h="1" m="0" sql="-sql" test
	make TASK="createLDFundamentalUoL" l="256" c="$(c)" g="4" a="5" d="2" h="1" m="0" sql="-sql" test
	make TASK="createLDFundamentalUoL" l="256" c="$(c)" g="8" a="5" d="2" h="1" m="0" sql="-sql" test
	make TASK="createLDFundamentalUoL" l="256" c="$(c)" g="16" a="5" d="2" h="1" m="0" sql="-sql" test
	make TASK="createLDFundamentalUoL" l="256" c="$(c)" g="32" a="5" d="2" h="1" m="0" sql="-sql" test

test_simulation :
	make TASK="createLDSimulationUoL" l="32" c="4" g="2" a="32" d="4" h="2" m="0" test

test_peertutoring :
	make TASK="createLDPeerTutoringUoL" l="8" c="1" g="2" a="16" d="0" h="0" m="0" test

test : build/$(TASK)/p_l$(l)_g$(g).class
	[ -f build/$(TASK)/p_l$(l)_g$(g).log ] || touch build/$(TASK)/p_l$(l)_g$(g).log
	date >> build/$(TASK)/p_l$(l)_g$(g).log
	echo '===============================' >> build/$(TASK)/p_l$(l)_g$(g).log
	cd bin; (time -p java $(JAVA_PARAMS) -classpath $(LIBS):. $(TASK).p_l$(l)_g$(g) >> ../build/$(TASK)/p_l$(l)_g$(g)_out.log) 2>> ../build/$(TASK)/p_l$(l)_g$(g).log
	echo '' >> build/$(TASK)/p_l$(l)_g$(g).log

#build/$(TASK)/p_l$(l)_c$(c)_g$(g)_a$(a)_d$(d)_h$(h)_m$(m).class : build/$(TASK)/p_l$(l)_c$(c)_g$(g)_a$(a)_d$(d)_h$(h)_m$(m).java $(JAVA_AUXS)
#	cd build; javac -classpath $(LDPATH)/src:$(LIBS):. ../$< -d ../bin

build/$(TASK)/p_l$(l)_g$(g).class : build/$(TASK)/p_l$(l)_g$(g).java $(JAVA_AUXS)
	cd build; javac -classpath $(LDPATH)/src:$(LIBS):. ../$< -d ../bin

#build/$(TASK)/p_l$(l)_c$(c)_g$(g)_a$(a)_d$(d)_h$(h)_m$(m).java : build/$(TASK)/p_l$(l)_c$(c)_g$(g)_a$(a)_d$(d)_h$(h)_m$(m).lisp \
#	build/$(TASK)/domain.java
#ifeq ($(format),xml)
#	java $(JAVA_PARAMS) -classpath $(LIBS) com.gamalocus.jshop2rt.InternalDomain -r1 $< $@ '$(TASK)' \
#		-xml 'LDOperatorConvert.convert(plan,owner).toXMLString()' \
#		'br.usp.ime.cg.automatedld.server.util.LDOperatorConvert'
#else
#	java $(JAVA_PARAMS) -classpath $(LIBS) com.gamalocus.jshop2rt.InternalDomain -r1 $< $@ '$(TASK)'
#endif

build/$(TASK)/p_l$(l)_g$(g).java : build/$(TASK)/p_l$(l)_g$(g).lisp build/$(TASK)/domain.java
	@if [ ! -f  build/$(TASK)/p_l$(l)_g$(g).java ]; then \
		java $(JAVA_PARAMS) -classpath $(LIBS) com.gamalocus.jshop2rt.InternalDomain -r1 $< $@ '$(TASK)'; \
	fi

$(JAVA_AUXS) :
	[ -d build/$(TASK) ] || mkdir -p build/$(TASK)
	@for dest in $(JAVA_AUXS) ; do \
		echo 'package $(TASK);\n' > $$dest; cat $(LDPATH)/test/$${dest#build/$(TASK)/} >> $$dest; \
	done

#build/$(TASK)/p_l$(l)_c$(c)_g$(g)_a$(a)_d$(d)_h$(h)_m$(m).lisp : bin/TestFactory.class
#	[ -d build/$(TASK) ] || mkdir -p build/$(TASK)
#	@if [ ! -f  build/$(TASK)/p_l$(l)_c$(c)_g$(g)_a$(a)_d$(d)_h$(h)_m$(m).lisp ]; then \
#		cd bin; java $(JAVA_PARAMS) -classpath $(LIBS):. TestFactory \
#		-l$(l) -c$(c) -g$(g) -a$(a) -d$(d) -h$(h) -m$(m) $(TASK) \
#		../build/$(TASK)/p_l$(l)_c$(c)_g$(g)_a$(a)_d$(d)_h$(h)_m$(m) \
#		p_l$(l)_c$(c)_g$(g)_a$(a)_d$(d)_h$(h)_m$(m); \
#	fi

build/$(TASK)/p_l$(l)_g$(g).lisp : bin/TestFactory.class
	[ -d build/$(TASK) ] || mkdir -p build/$(TASK)
	@if [ ! -f  build/$(TASK)/p_l$(l)_g$(g).lisp ]; then \
		cd bin; java $(JAVA_PARAMS) -classpath $(LIBS):. \
		TestFactory -l$(l) -g$(g) $(TASK) ../build/$(TASK)/p_l$(l)_g$(g) p_l$(l)_g$(g); \
	fi

build/automatedldtest.sql.gz : bin/TestFactory.class
	@if [ ! -f build/automatedldtest.sql.gz ]; then \
		cd bin; java $(JAVA_PARAMS) -classpath $(LIBS):. \
			TestFactory -l128 -s8 -f16 -a32 testSQL automatedldtest; \
		gzip -9 automatedldtest.sql; cp automatedldtest.sql.gz ../build/automatedldtest.sql.gz; \
	fi

bin/TestFactory.class : $(LDPATH)/test/TestFactory.java
	cd bin; javac -classpath $(LDPATH)/test:$(LDPATH)/src:$(LIBS):. $(LDPATH)/test/TestFactory.java -d .

# domain problem files #

build/$(TASK)/domain.java : build/domain.lisp
	cd build; java $(JAVA_PARAMS) -classpath $(LIBS) com.gamalocus.jshop2rt.InternalDomain domain.lisp $(TASK)/domain.java '$(TASK)'

build/domain.lisp :
	echo '(defdomain domain(' > build/domain.lisp
	cat commons/main.lisp >> build/domain.lisp
	cat commons/learner-domain.lisp >> build/domain.lisp
	cat commons/instrplanning.lisp >> build/domain.lisp
	cat commons/ldoperators.lisp >> build/domain.lisp
	cat commons/ldelements/*.lisp >> build/domain.lisp
	#cat microrroteiros/ilevents/*.lisp >> build/domain.lisp
	#cat microrroteiros/interactions/*.lisp >> build/domain.lisp
	#cat microrroteiros/ipatterns/*.lisp >> build/domain.lisp
	#cat microrroteiros/roles/*.lisp >> build/domain.lisp
	#cat microrroteiros/learningstrategies/*.lisp >> build/domain.lisp
	#cat microrroteiros/clphases/*.lisp >> build/domain.lisp
	#cat microrroteiros/clscenarios/*.lisp >> build/domain.lisp
	#cat macrorroteiros/sessions/inputoutput/*.lisp >> build/domain.lisp
	#cat macrorroteiros/sessions/*.lisp >> build/domain.lisp
	#cat macrorroteiros/groupactivities/*.lisp >> build/domain.lisp
	#cat macrorroteiros/phases/*.lisp >> build/domain.lisp
	#cat macrorroteiros/clfps/*.lisp >> build/domain.lisp
	#cat macrorroteiros/integration.lisp >> build/domain.lisp
	#cat scenarios/sessions/inputoutput/*.lisp >> build/domain.lisp
	#cat scenarios/sessions/*.lisp >> build/domain.lisp
	cat scenarios/groupactivities/*.lisp >> build/domain.lisp
	cat scenarios/phases/*.lisp >> build/domain.lisp
	cat scenarios/scripts/*.lisp >> build/domain.lisp
	cat scenarios/uols/*.lisp >> build/domain.lisp
	echo '))' >> build/domain.lisp

clean :
	rm -rf bin/*
	rm -f build/domain.lisp
	rm -f build/*/*.java
	rm -f build/*/*.txt

clean_all :
	rm -rf build/*
	rm -rf bin/*
