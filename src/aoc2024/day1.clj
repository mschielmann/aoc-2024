(require '[clojure.string :as string])

(defn find-first-number-in-line
  [line]
  (Integer/parseInt (first (string/split line #"\s"))))

(defn find-last-number-in-line
  [line]
  (Integer/parseInt (last (string/split line #"\s"))))

(defn read-left-column-sorted
  [lines]
  (sort (for [line (string/split lines #"\n")] (find-first-number-in-line line))))

(defn read-right-column-sorted
  [lines]
  (sort (for [line (string/split lines #"\n")] (find-last-number-in-line line))))

(defn calculate-diff-between-columns
  [left-col right-col]
  (reduce + (for [diff (map - left-col right-col)] (abs diff))
          ))

(defn day1-part1
  [input]
  (calculate-diff-between-columns (read-left-column-sorted input) (read-right-column-sorted input)))


(defn calculate-score
  [left-col right-col]
  (reduce + (for [diff (map - left-col right-col)] (abs diff))
          ))

(defn day1-part2
  [input]
  (let [left-column (read-left-column-sorted input)
        right-column (read-right-column-sorted input)]
    (reduce + (for [index (range 0 (count left-column))] (* (nth left-column index) (count (filter #(= % (nth left-column index)) right-column))))))
  )

(println (day1-part1 "3   4\n4   3\n2   5\n1   3\n3   9\n3   3"))
(println (day1-part1 "76309   75213\n79731   28444\n29583   71339\n60992   99148\n34680   74530\n45691   82519\n55358   22047\n95523   45384\n37661   82208\n33464   91461\n26897   96393\n76556   76554\n82316   98880\n92079   23082\n55539   10033\n65931   66060\n98880   60464\n19348   41458\n72003   84074\n78401   78856\n53187   72003\n65201   71211\n45971   12776\n45911   26854\n37527   13462\n28891   28444\n82801   81076\n29496   21971\n81662   12472\n89956   51107\n92833   22498\n23135   19348\n33661   51107\n48499   81114\n53651   65515\n26075   73072\n67647   90255\n90805   38056\n39949   68042\n76487   86922\n95115   94618\n11937   76761\n89547   72003\n25780   18607\n45017   84423\n43306   57853\n68164   22550\n56564   62505\n75018   52627\n23253   57654\n65165   55756\n31517   14874\n20876   72883\n80624   76452\n33117   67195\n64410   15109\n41934   83416\n89782   34566\n71805   38212\n73244   47902\n91360   78672\n45112   62842\n12869   59690\n90665   89809\n69340   29496\n91603   69938\n56320   67034\n17932   62842\n18431   29380\n31849   75256\n72699   28903\n87247   95908\n40628   67697\n63635   87577\n39517   86619\n11212   57615\n38117   51660\n36016   22309\n10931   19763\n76357   21412\n75652   61857\n98810   38436\n38749   23524\n86048   72883\n63513   72883\n45687   67490\n60836   12821\n94034   51660\n80411   25554\n21091   19763\n16564   36401\n44503   22575\n57654   66781\n31146   46927\n97857   20234\n25682   75256\n93045   13462\n68754   72883\n17237   72883\n92066   74137\n93749   51512\n34830   10322\n99272   67697\n45274   60464\n38929   80865\n34134   48329\n68249   47187\n48916   83133\n61528   29496\n90233   97345\n54872   14127\n44233   75524\n91023   52472\n24635   11482\n40466   19763\n46905   66085\n25902   94618\n35889   42397\n88185   69459\n64759   63070\n11316   72003\n73715   38056\n60712   75256\n72685   81152\n77252   66060\n28506   61431\n54298   89763\n90658   62842\n57205   69364\n23674   57548\n64953   19763\n53241   12916\n13222   33059\n15152   19763\n92661   60464\n61816   94618\n76099   75071\n38554   38436\n21189   22498\n38784   91603\n65754   62842\n87476   98880\n56430   90853\n76366   86864\n48121   83675\n71894   81336\n82170   67697\n90347   60012\n21071   50167\n92246   40121\n36480   66608\n22854   54282\n99368   83869\n83605   69528\n65136   85197\n90644   80851\n68309   97711\n77685   15072\n10032   11404\n71312   21971\n95462   42893\n53698   28903\n41458   80851\n80635   80851\n26127   93602\n15692   16750\n26810   92990\n87800   97117\n91599   31201\n97670   53183\n31216   82887\n80047   29496\n57838   15694\n40849   18977\n64159   68248\n89709   60902\n14381   36340\n25729   66727\n36202   51660\n97364   57654\n34691   57479\n35917   21577\n15191   77547\n24872   42035\n94140   30529\n93963   42786\n55950   74745\n80851   73127\n16667   28903\n46647   53539\n24917   41629\n43622   21688\n37442   94618\n40641   60464\n12670   64945\n78129   33880\n47403   21412\n15283   81303\n24283   92601\n76777   33434\n53791   88560\n82919   79661\n77544   25196\n40160   88979\n86172   57853\n38241   52145\n60464   98880\n17675   72883\n83513   38056\n13022   41458\n68472   23196\n22498   10066\n29522   70183\n80236   41513\n37585   22498\n70287   79234\n81783   22498\n14685   40811\n95584   18124\n47126   43277\n46799   53781\n60372   42786\n29724   51541\n93734   38212\n48291   13462\n10590   57306\n42879   81296\n98898   91603\n94223   13462\n49303   48982\n87417   21971\n17709   41952\n76716   64094\n29881   44586\n26599   93340\n24757   41458\n15666   19763\n44542   98880\n30400   27123\n44519   29496\n10588   93022\n41850   17815\n98878   79099\n85952   22498\n11119   64255\n75872   22498\n46488   86922\n26202   62842\n95599   81076\n23529   41458\n60375   59633\n62608   35235\n50724   98880\n51119   92701\n20960   24242\n91487   53719\n62298   77547\n17790   19763\n34307   55594\n49446   42812\n85537   71894\n80619   98880\n25391   64094\n16005   60464\n80510   66044\n84955   38436\n88821   91603\n17492   42786\n81026   41458\n19683   22498\n79887   75256\n36893   33059\n56380   80851\n48530   42786\n32923   33059\n29965   81076\n18532   81363\n25026   91603\n72561   62842\n94980   38056\n32432   53183\n55534   38436\n66162   64255\n77645   75256\n70443   38056\n29960   41458\n92757   26451\n11444   21971\n52688   38436\n41268   22621\n97231   49903\n51183   57052\n90927   26985\n97265   42786\n66813   22007\n63206   83227\n78745   99837\n60347   79617\n46179   29436\n73348   77547\n68926   27421\n24241   43292\n23989   21971\n76893   60464\n96995   38211\n94457   17361\n33924   91603\n65919   38056\n98919   22498\n61147   77547\n25172   25516\n66855   60700\n98423   91668\n13462   29007\n78075   64094\n99192   41551\n61341   22221\n57853   65000\n64255   91984\n44260   15605\n34883   21971\n88936   41375\n87848   45956\n82017   59273\n65191   77547\n52966   71894\n36879   83506\n75723   28903\n63490   11235\n89580   98372\n41331   21971\n47488   71894\n89934   91603\n25785   74938\n73107   32099\n79658   60464\n95693   14737\n91422   57654\n96745   86600\n39149   71623\n98394   54803\n82163   36159\n95052   38436\n16720   82983\n63140   22498\n23823   84914\n50296   71894\n40070   38212\n51107   38056\n95702   21412\n63439   72003\n70522   51660\n67070   66147\n78368   75455\n33938   74618\n36370   92122\n77547   99234\n36047   64094\n53669   73226\n71919   77547\n66864   75256\n38056   51660\n91341   61913\n37606   22498\n50946   29496\n28444   80851\n41082   41458\n17087   20616\n83635   22498\n70177   61491\n68184   19348\n54012   17507\n38198   81076\n40811   46612\n70047   35669\n34846   57853\n62305   71894\n59272   19763\n40659   11104\n23800   42786\n64175   20190\n68120   52879\n35213   13462\n85144   60464\n83815   69928\n69466   64255\n69940   54069\n79153   39514\n26397   98880\n10870   42786\n11814   61605\n83212   95356\n47789   29496\n32399   65379\n47939   97345\n81076   93623\n48371   68260\n20554   51660\n25316   80851\n85993   39286\n69729   18711\n34131   41603\n99316   15855\n15760   33756\n11727   57654\n73101   73191\n93009   58546\n63218   76005\n60263   84618\n64150   65222\n32042   75256\n35235   18159\n77209   32300\n64094   76684\n46101   90505\n99642   86922\n29258   98880\n40802   62842\n47215   35310\n25170   64094\n80039   87125\n85895   53213\n85277   34676\n24143   65226\n32337   22314\n71599   71200\n33477   72883\n24883   21971\n19419   97222\n59427   67697\n72661   97478\n62996   29496\n12525   67697\n99041   17700\n20625   19348\n67886   45087\n42662   41458\n28976   94451\n11277   55388\n88403   19763\n77265   32689\n71034   64255\n44618   53790\n45540   27148\n53781   53412\n44920   88690\n68235   69804\n14758   83239\n21668   31070\n87671   40811\n69745   54682\n95603   42197\n15999   87006\n43079   77547\n28105   42498\n33119   77660\n68650   81076\n94618   72883\n92897   82856\n34834   86922\n29210   33710\n58769   45753\n33360   38212\n19762   51660\n52993   72883\n74090   33902\n73668   12703\n67667   80986\n56341   87195\n42838   28903\n93432   19763\n84325   56270\n72643   62842\n77464   81076\n91846   77547\n75389   24109\n22248   93422\n15496   47644\n60779   21971\n14645   28903\n71653   75429\n41937   88087\n97389   62842\n55995   64094\n35488   47300\n56394   96902\n32108   11813\n55582   41458\n85261   19763\n98501   52280\n17412   73155\n62946   75256\n45369   30393\n17834   81076\n39228   67134\n45644   86198\n70980   72003\n42334   64094\n29852   49234\n40025   22174\n56532   56346\n94361   89533\n78649   42786\n77448   81297\n81128   77547\n62842   75256\n52291   41710\n40473   81493\n50907   19763\n73714   52966\n99652   80851\n13997   59464\n32984   96842\n85656   31414\n19177   53183\n58598   33333\n48325   64618\n60732   17729\n20343   21971\n96365   67697\n17674   49780\n95012   57853\n60953   86922\n62943   44091\n25163   63493\n71429   19763\n94437   40811\n53160   60279\n89277   91603\n25998   47890\n53281   45307\n82655   81076\n58683   98880\n34567   57853\n67319   86276\n71752   86922\n32419   81076\n99187   57654\n99426   71894\n24165   25888\n37843   29553\n97105   21412\n32460   37041\n29663   27331\n59713   67414\n45188   84541\n14348   43314\n62746   40811\n46870   83863\n50841   38056\n59445   16050\n12925   98880\n57452   85546\n36324   60464\n67373   81076\n86514   73624\n56074   51107\n66208   92937\n91677   87311\n59472   36022\n73550   76544\n44359   91603\n67706   54480\n32462   26551\n86672   68321\n35231   57853\n53759   88043\n94902   80851\n94326   28606\n78387   51107\n64407   57853\n30177   17341\n52328   19348\n32836   64094\n27500   21971\n66034   86985\n70645   81076\n41249   74832\n23305   71814\n61958   69681\n76187   46028\n95216   37603\n81846   67869\n47377   98660\n77226   22498\n47927   20033\n26606   30796\n57767   41458\n68443   71807\n53742   22475\n14866   67697\n13517   75256\n12941   22498\n18949   71894\n91218   77547\n54173   19763\n39748   45326\n78360   99324\n11720   51107\n29782   53692\n43041   24930\n35760   19763\n28118   67697\n48978   38056\n32968   21971\n10841   68694\n88712   99460\n55899   20431\n96213   81076\n11205   67697\n78331   94591\n98064   60719\n55020   71894\n54837   29496\n32560   77953\n84271   64094\n12334   53273\n60354   98880\n18875   45344\n79143   38056\n23233   84636\n61563   88447\n31425   45195\n71874   51660\n72444   89972\n53574   57736\n23459   39741\n46584   13200\n67106   41458\n28010   19505\n92985   97345\n36682   21971\n12501   99944\n16169   76904\n43802   32400\n63772   26347\n75759   98880\n24020   44873\n72479   75256\n58596   65558\n79734   19763\n29532   81076\n65742   94618\n69210   81076\n32186   91603\n48745   94618\n60568   66618\n49589   38056\n38212   19348\n48399   68926\n28282   62842\n43098   69228\n28937   33723\n36026   39105\n36024   98087\n84966   30771\n59984   51660\n89201   60464\n21971   29496\n50899   64094\n76523   85510\n21988   20844\n75667   92452\n24010   28903\n34214   21576\n58811   77652\n51628   30799\n73612   38056\n23096   52865\n39135   66625\n69128   49400\n32494   39597\n67143   72170\n68372   47908\n81952   38056\n88192   38056\n83029   67697\n63532   22498\n54899   75256\n96592   28503\n17379   13462\n16417   19843\n50554   41929\n25532   68199\n86596   38056\n25412   77359\n97345   37353\n19051   78038\n95135   80851\n43190   38436\n16851   80851\n50939   71931\n20348   72883\n62130   37721\n75609   50259\n13811   91603\n80903   79684\n58594   12415\n21090   13462\n90571   97345\n54287   10341\n31596   94618\n93992   98880\n26590   35235\n25317   26365\n94102   75256\n53183   61183\n57107   37169\n80457   58396\n48710   81076\n56696   71894\n96203   22833\n84426   24326\n66196   15680\n76056   64094\n86506   67761\n62627   22498\n30931   66060\n70026   77819\n93319   57170\n81820   64094\n86702   72003\n99446   50653\n77640   91603\n67087   90541\n80068   51107\n65835   56004\n13105   46230\n65748   91284\n80758   41458\n19345   47474\n56661   77547\n12043   67697\n50136   64851\n79931   16117\n51660   21003\n91875   72883\n64857   68150\n14513   93047\n31955   77467\n42546   67697\n49089   51660\n77824   28916\n15115   65178\n98454   40431\n15654   38056\n22270   38826\n73592   29496\n72221   90578\n99258   57441\n70502   34724\n88720   67697\n57057   51660\n36225   19763\n93724   98880\n37728   51660\n25140   34250\n57373   89903\n93720   64821\n90834   28903\n37440   14002\n67370   73712\n46370   33621\n63554   39553\n27180   33899\n48396   80851\n49431   68934\n90431   17857\n84310   97017\n37110   42786\n34732   64255\n46171   25574\n58999   30048\n57776   67697\n99514   96621\n38870   60533\n96826   32872\n66302   22498\n56005   52386\n15218   72883\n82329   94052\n60643   31279\n69475   29496\n61286   15538\n32797   69919\n48924   57853\n61994   73550\n63771   82704\n41809   13024\n97274   97164\n33059   42786\n45700   40001\n40917   17001\n33486   72003\n33666   59194\n63745   77859\n68420   80851\n55719   27549\n26294   21412\n67613   69595\n38497   31870\n33455   80851\n29237   68898\n53016   44791\n36157   65971\n20983   38056\n43937   52966\n90852   76144\n86318   53334\n30612   62842\n90434   56570\n25697   77841\n22662   70772\n89638   33059\n26116   52871\n84518   60464\n55725   75500\n81669   33853\n99680   56409\n11056   77547\n21585   58485\n37854   70553\n27402   64832\n39624   41458\n92759   72003\n42786   81984\n19929   50841\n21412   75256\n91518   88235\n39607   23909\n82239   13462\n27192   51858\n46537   33593\n38436   71894\n79708   13462\n39914   75256\n53695   21830\n40348   60464\n40694   42202\n19663   46959\n16165   67697\n26764   66060\n62435   10581\n58398   29571\n17348   95270\n90054   22498\n48870   41458\n20742   45699\n66060   97867\n69792   65746\n33979   24259\n80596   13462\n38208   94618\n53092   98687\n53583   32555\n17488   71894\n76692   38436\n71114   67532\n50119   43332\n60702   45943\n98910   31092\n24697   84922\n91990   92651\n84668   47907\n62646   58437\n18722   99286\n25746   40968\n19142   68959\n74638   38654\n61297   79634\n19217   33484\n28041   34064\n15985   12822\n28848   57853\n28628   17208\n23312   35979\n70752   29496\n11513   22498\n48405   38216\n91941   22498\n98013   80851\n23286   84866\n20244   44309\n83249   22059\n23960   71894\n19258   57572\n86488   61827\n57252   32489\n46820   91603\n39964   55055\n80837   22985\n99090   75256\n69839   81076\n98396   75256\n30774   88548\n86470   22167\n23371   64094\n23128   84004\n58818   80851\n45372   80851\n27966   97345\n60009   67697\n65289   32158\n91781   32885\n80156   65660\n97254   42786\n48298   41159\n54722   38021\n81261   81076\n86922   22498\n55476   31657\n57009   14306\n38000   38056\n85253   38436\n76055   41458\n59410   97345\n88583   53781\n18304   52775\n75050   64094\n70029   55636\n20423   65761\n81440   54815\n82295   13462\n25089   28903\n16484   19348\n23071   49803\n57112   35235\n63721   60158\n68579   94832\n21977   78498\n43592   72883\n40060   41458\n20413   42337\n40283   34311\n30206   96070\n46075   91603\n70006   19763\n75130   91603\n60612   28903\n64928   23183\n96097   21971\n72883   40811\n20769   68024\n97961   41458\n46704   60464\n79660   21412\n70165   97160\n37654   62842\n40556   28903\n15332   43586\n19763   41974\n79356   67697\n42155   62829\n51863   93968\n80541   64094\n16392   51660\n67697   98880\n28903   51664\n98379   11061\n73277   59160\n91515   49151\n88086   17578\n36014   38056\n68997   72883\n48767   71894\n61448   20757\n70899   38212\n65598   42786\n61699   31701\n73408   21499\n88878   49200\n12559   91603\n51392   13481\n35286   97345\n84379   67963\n93438   91603\n60752   53106\n19987   81076\n63280   35027\n43747   71810\n22803   66237\n75256   75256\n70441   72003\n77992   57743\n70884   21412\n91936   77547\n39673   53183\n31518   19763\n23066   48344\n45455   77547\n58606   32254\n33075   21971\n12200   19763\n42764   79555\n45004   94858\n87970   98880\n52319   38436\n81837   86922\n67858   57654\n86460   95056"))

(println (day1-part2 "3   4\n4   3\n2   5\n1   3\n3   9\n3   3"))
(println (day1-part2 "76309   75213\n79731   28444\n29583   71339\n60992   99148\n34680   74530\n45691   82519\n55358   22047\n95523   45384\n37661   82208\n33464   91461\n26897   96393\n76556   76554\n82316   98880\n92079   23082\n55539   10033\n65931   66060\n98880   60464\n19348   41458\n72003   84074\n78401   78856\n53187   72003\n65201   71211\n45971   12776\n45911   26854\n37527   13462\n28891   28444\n82801   81076\n29496   21971\n81662   12472\n89956   51107\n92833   22498\n23135   19348\n33661   51107\n48499   81114\n53651   65515\n26075   73072\n67647   90255\n90805   38056\n39949   68042\n76487   86922\n95115   94618\n11937   76761\n89547   72003\n25780   18607\n45017   84423\n43306   57853\n68164   22550\n56564   62505\n75018   52627\n23253   57654\n65165   55756\n31517   14874\n20876   72883\n80624   76452\n33117   67195\n64410   15109\n41934   83416\n89782   34566\n71805   38212\n73244   47902\n91360   78672\n45112   62842\n12869   59690\n90665   89809\n69340   29496\n91603   69938\n56320   67034\n17932   62842\n18431   29380\n31849   75256\n72699   28903\n87247   95908\n40628   67697\n63635   87577\n39517   86619\n11212   57615\n38117   51660\n36016   22309\n10931   19763\n76357   21412\n75652   61857\n98810   38436\n38749   23524\n86048   72883\n63513   72883\n45687   67490\n60836   12821\n94034   51660\n80411   25554\n21091   19763\n16564   36401\n44503   22575\n57654   66781\n31146   46927\n97857   20234\n25682   75256\n93045   13462\n68754   72883\n17237   72883\n92066   74137\n93749   51512\n34830   10322\n99272   67697\n45274   60464\n38929   80865\n34134   48329\n68249   47187\n48916   83133\n61528   29496\n90233   97345\n54872   14127\n44233   75524\n91023   52472\n24635   11482\n40466   19763\n46905   66085\n25902   94618\n35889   42397\n88185   69459\n64759   63070\n11316   72003\n73715   38056\n60712   75256\n72685   81152\n77252   66060\n28506   61431\n54298   89763\n90658   62842\n57205   69364\n23674   57548\n64953   19763\n53241   12916\n13222   33059\n15152   19763\n92661   60464\n61816   94618\n76099   75071\n38554   38436\n21189   22498\n38784   91603\n65754   62842\n87476   98880\n56430   90853\n76366   86864\n48121   83675\n71894   81336\n82170   67697\n90347   60012\n21071   50167\n92246   40121\n36480   66608\n22854   54282\n99368   83869\n83605   69528\n65136   85197\n90644   80851\n68309   97711\n77685   15072\n10032   11404\n71312   21971\n95462   42893\n53698   28903\n41458   80851\n80635   80851\n26127   93602\n15692   16750\n26810   92990\n87800   97117\n91599   31201\n97670   53183\n31216   82887\n80047   29496\n57838   15694\n40849   18977\n64159   68248\n89709   60902\n14381   36340\n25729   66727\n36202   51660\n97364   57654\n34691   57479\n35917   21577\n15191   77547\n24872   42035\n94140   30529\n93963   42786\n55950   74745\n80851   73127\n16667   28903\n46647   53539\n24917   41629\n43622   21688\n37442   94618\n40641   60464\n12670   64945\n78129   33880\n47403   21412\n15283   81303\n24283   92601\n76777   33434\n53791   88560\n82919   79661\n77544   25196\n40160   88979\n86172   57853\n38241   52145\n60464   98880\n17675   72883\n83513   38056\n13022   41458\n68472   23196\n22498   10066\n29522   70183\n80236   41513\n37585   22498\n70287   79234\n81783   22498\n14685   40811\n95584   18124\n47126   43277\n46799   53781\n60372   42786\n29724   51541\n93734   38212\n48291   13462\n10590   57306\n42879   81296\n98898   91603\n94223   13462\n49303   48982\n87417   21971\n17709   41952\n76716   64094\n29881   44586\n26599   93340\n24757   41458\n15666   19763\n44542   98880\n30400   27123\n44519   29496\n10588   93022\n41850   17815\n98878   79099\n85952   22498\n11119   64255\n75872   22498\n46488   86922\n26202   62842\n95599   81076\n23529   41458\n60375   59633\n62608   35235\n50724   98880\n51119   92701\n20960   24242\n91487   53719\n62298   77547\n17790   19763\n34307   55594\n49446   42812\n85537   71894\n80619   98880\n25391   64094\n16005   60464\n80510   66044\n84955   38436\n88821   91603\n17492   42786\n81026   41458\n19683   22498\n79887   75256\n36893   33059\n56380   80851\n48530   42786\n32923   33059\n29965   81076\n18532   81363\n25026   91603\n72561   62842\n94980   38056\n32432   53183\n55534   38436\n66162   64255\n77645   75256\n70443   38056\n29960   41458\n92757   26451\n11444   21971\n52688   38436\n41268   22621\n97231   49903\n51183   57052\n90927   26985\n97265   42786\n66813   22007\n63206   83227\n78745   99837\n60347   79617\n46179   29436\n73348   77547\n68926   27421\n24241   43292\n23989   21971\n76893   60464\n96995   38211\n94457   17361\n33924   91603\n65919   38056\n98919   22498\n61147   77547\n25172   25516\n66855   60700\n98423   91668\n13462   29007\n78075   64094\n99192   41551\n61341   22221\n57853   65000\n64255   91984\n44260   15605\n34883   21971\n88936   41375\n87848   45956\n82017   59273\n65191   77547\n52966   71894\n36879   83506\n75723   28903\n63490   11235\n89580   98372\n41331   21971\n47488   71894\n89934   91603\n25785   74938\n73107   32099\n79658   60464\n95693   14737\n91422   57654\n96745   86600\n39149   71623\n98394   54803\n82163   36159\n95052   38436\n16720   82983\n63140   22498\n23823   84914\n50296   71894\n40070   38212\n51107   38056\n95702   21412\n63439   72003\n70522   51660\n67070   66147\n78368   75455\n33938   74618\n36370   92122\n77547   99234\n36047   64094\n53669   73226\n71919   77547\n66864   75256\n38056   51660\n91341   61913\n37606   22498\n50946   29496\n28444   80851\n41082   41458\n17087   20616\n83635   22498\n70177   61491\n68184   19348\n54012   17507\n38198   81076\n40811   46612\n70047   35669\n34846   57853\n62305   71894\n59272   19763\n40659   11104\n23800   42786\n64175   20190\n68120   52879\n35213   13462\n85144   60464\n83815   69928\n69466   64255\n69940   54069\n79153   39514\n26397   98880\n10870   42786\n11814   61605\n83212   95356\n47789   29496\n32399   65379\n47939   97345\n81076   93623\n48371   68260\n20554   51660\n25316   80851\n85993   39286\n69729   18711\n34131   41603\n99316   15855\n15760   33756\n11727   57654\n73101   73191\n93009   58546\n63218   76005\n60263   84618\n64150   65222\n32042   75256\n35235   18159\n77209   32300\n64094   76684\n46101   90505\n99642   86922\n29258   98880\n40802   62842\n47215   35310\n25170   64094\n80039   87125\n85895   53213\n85277   34676\n24143   65226\n32337   22314\n71599   71200\n33477   72883\n24883   21971\n19419   97222\n59427   67697\n72661   97478\n62996   29496\n12525   67697\n99041   17700\n20625   19348\n67886   45087\n42662   41458\n28976   94451\n11277   55388\n88403   19763\n77265   32689\n71034   64255\n44618   53790\n45540   27148\n53781   53412\n44920   88690\n68235   69804\n14758   83239\n21668   31070\n87671   40811\n69745   54682\n95603   42197\n15999   87006\n43079   77547\n28105   42498\n33119   77660\n68650   81076\n94618   72883\n92897   82856\n34834   86922\n29210   33710\n58769   45753\n33360   38212\n19762   51660\n52993   72883\n74090   33902\n73668   12703\n67667   80986\n56341   87195\n42838   28903\n93432   19763\n84325   56270\n72643   62842\n77464   81076\n91846   77547\n75389   24109\n22248   93422\n15496   47644\n60779   21971\n14645   28903\n71653   75429\n41937   88087\n97389   62842\n55995   64094\n35488   47300\n56394   96902\n32108   11813\n55582   41458\n85261   19763\n98501   52280\n17412   73155\n62946   75256\n45369   30393\n17834   81076\n39228   67134\n45644   86198\n70980   72003\n42334   64094\n29852   49234\n40025   22174\n56532   56346\n94361   89533\n78649   42786\n77448   81297\n81128   77547\n62842   75256\n52291   41710\n40473   81493\n50907   19763\n73714   52966\n99652   80851\n13997   59464\n32984   96842\n85656   31414\n19177   53183\n58598   33333\n48325   64618\n60732   17729\n20343   21971\n96365   67697\n17674   49780\n95012   57853\n60953   86922\n62943   44091\n25163   63493\n71429   19763\n94437   40811\n53160   60279\n89277   91603\n25998   47890\n53281   45307\n82655   81076\n58683   98880\n34567   57853\n67319   86276\n71752   86922\n32419   81076\n99187   57654\n99426   71894\n24165   25888\n37843   29553\n97105   21412\n32460   37041\n29663   27331\n59713   67414\n45188   84541\n14348   43314\n62746   40811\n46870   83863\n50841   38056\n59445   16050\n12925   98880\n57452   85546\n36324   60464\n67373   81076\n86514   73624\n56074   51107\n66208   92937\n91677   87311\n59472   36022\n73550   76544\n44359   91603\n67706   54480\n32462   26551\n86672   68321\n35231   57853\n53759   88043\n94902   80851\n94326   28606\n78387   51107\n64407   57853\n30177   17341\n52328   19348\n32836   64094\n27500   21971\n66034   86985\n70645   81076\n41249   74832\n23305   71814\n61958   69681\n76187   46028\n95216   37603\n81846   67869\n47377   98660\n77226   22498\n47927   20033\n26606   30796\n57767   41458\n68443   71807\n53742   22475\n14866   67697\n13517   75256\n12941   22498\n18949   71894\n91218   77547\n54173   19763\n39748   45326\n78360   99324\n11720   51107\n29782   53692\n43041   24930\n35760   19763\n28118   67697\n48978   38056\n32968   21971\n10841   68694\n88712   99460\n55899   20431\n96213   81076\n11205   67697\n78331   94591\n98064   60719\n55020   71894\n54837   29496\n32560   77953\n84271   64094\n12334   53273\n60354   98880\n18875   45344\n79143   38056\n23233   84636\n61563   88447\n31425   45195\n71874   51660\n72444   89972\n53574   57736\n23459   39741\n46584   13200\n67106   41458\n28010   19505\n92985   97345\n36682   21971\n12501   99944\n16169   76904\n43802   32400\n63772   26347\n75759   98880\n24020   44873\n72479   75256\n58596   65558\n79734   19763\n29532   81076\n65742   94618\n69210   81076\n32186   91603\n48745   94618\n60568   66618\n49589   38056\n38212   19348\n48399   68926\n28282   62842\n43098   69228\n28937   33723\n36026   39105\n36024   98087\n84966   30771\n59984   51660\n89201   60464\n21971   29496\n50899   64094\n76523   85510\n21988   20844\n75667   92452\n24010   28903\n34214   21576\n58811   77652\n51628   30799\n73612   38056\n23096   52865\n39135   66625\n69128   49400\n32494   39597\n67143   72170\n68372   47908\n81952   38056\n88192   38056\n83029   67697\n63532   22498\n54899   75256\n96592   28503\n17379   13462\n16417   19843\n50554   41929\n25532   68199\n86596   38056\n25412   77359\n97345   37353\n19051   78038\n95135   80851\n43190   38436\n16851   80851\n50939   71931\n20348   72883\n62130   37721\n75609   50259\n13811   91603\n80903   79684\n58594   12415\n21090   13462\n90571   97345\n54287   10341\n31596   94618\n93992   98880\n26590   35235\n25317   26365\n94102   75256\n53183   61183\n57107   37169\n80457   58396\n48710   81076\n56696   71894\n96203   22833\n84426   24326\n66196   15680\n76056   64094\n86506   67761\n62627   22498\n30931   66060\n70026   77819\n93319   57170\n81820   64094\n86702   72003\n99446   50653\n77640   91603\n67087   90541\n80068   51107\n65835   56004\n13105   46230\n65748   91284\n80758   41458\n19345   47474\n56661   77547\n12043   67697\n50136   64851\n79931   16117\n51660   21003\n91875   72883\n64857   68150\n14513   93047\n31955   77467\n42546   67697\n49089   51660\n77824   28916\n15115   65178\n98454   40431\n15654   38056\n22270   38826\n73592   29496\n72221   90578\n99258   57441\n70502   34724\n88720   67697\n57057   51660\n36225   19763\n93724   98880\n37728   51660\n25140   34250\n57373   89903\n93720   64821\n90834   28903\n37440   14002\n67370   73712\n46370   33621\n63554   39553\n27180   33899\n48396   80851\n49431   68934\n90431   17857\n84310   97017\n37110   42786\n34732   64255\n46171   25574\n58999   30048\n57776   67697\n99514   96621\n38870   60533\n96826   32872\n66302   22498\n56005   52386\n15218   72883\n82329   94052\n60643   31279\n69475   29496\n61286   15538\n32797   69919\n48924   57853\n61994   73550\n63771   82704\n41809   13024\n97274   97164\n33059   42786\n45700   40001\n40917   17001\n33486   72003\n33666   59194\n63745   77859\n68420   80851\n55719   27549\n26294   21412\n67613   69595\n38497   31870\n33455   80851\n29237   68898\n53016   44791\n36157   65971\n20983   38056\n43937   52966\n90852   76144\n86318   53334\n30612   62842\n90434   56570\n25697   77841\n22662   70772\n89638   33059\n26116   52871\n84518   60464\n55725   75500\n81669   33853\n99680   56409\n11056   77547\n21585   58485\n37854   70553\n27402   64832\n39624   41458\n92759   72003\n42786   81984\n19929   50841\n21412   75256\n91518   88235\n39607   23909\n82239   13462\n27192   51858\n46537   33593\n38436   71894\n79708   13462\n39914   75256\n53695   21830\n40348   60464\n40694   42202\n19663   46959\n16165   67697\n26764   66060\n62435   10581\n58398   29571\n17348   95270\n90054   22498\n48870   41458\n20742   45699\n66060   97867\n69792   65746\n33979   24259\n80596   13462\n38208   94618\n53092   98687\n53583   32555\n17488   71894\n76692   38436\n71114   67532\n50119   43332\n60702   45943\n98910   31092\n24697   84922\n91990   92651\n84668   47907\n62646   58437\n18722   99286\n25746   40968\n19142   68959\n74638   38654\n61297   79634\n19217   33484\n28041   34064\n15985   12822\n28848   57853\n28628   17208\n23312   35979\n70752   29496\n11513   22498\n48405   38216\n91941   22498\n98013   80851\n23286   84866\n20244   44309\n83249   22059\n23960   71894\n19258   57572\n86488   61827\n57252   32489\n46820   91603\n39964   55055\n80837   22985\n99090   75256\n69839   81076\n98396   75256\n30774   88548\n86470   22167\n23371   64094\n23128   84004\n58818   80851\n45372   80851\n27966   97345\n60009   67697\n65289   32158\n91781   32885\n80156   65660\n97254   42786\n48298   41159\n54722   38021\n81261   81076\n86922   22498\n55476   31657\n57009   14306\n38000   38056\n85253   38436\n76055   41458\n59410   97345\n88583   53781\n18304   52775\n75050   64094\n70029   55636\n20423   65761\n81440   54815\n82295   13462\n25089   28903\n16484   19348\n23071   49803\n57112   35235\n63721   60158\n68579   94832\n21977   78498\n43592   72883\n40060   41458\n20413   42337\n40283   34311\n30206   96070\n46075   91603\n70006   19763\n75130   91603\n60612   28903\n64928   23183\n96097   21971\n72883   40811\n20769   68024\n97961   41458\n46704   60464\n79660   21412\n70165   97160\n37654   62842\n40556   28903\n15332   43586\n19763   41974\n79356   67697\n42155   62829\n51863   93968\n80541   64094\n16392   51660\n67697   98880\n28903   51664\n98379   11061\n73277   59160\n91515   49151\n88086   17578\n36014   38056\n68997   72883\n48767   71894\n61448   20757\n70899   38212\n65598   42786\n61699   31701\n73408   21499\n88878   49200\n12559   91603\n51392   13481\n35286   97345\n84379   67963\n93438   91603\n60752   53106\n19987   81076\n63280   35027\n43747   71810\n22803   66237\n75256   75256\n70441   72003\n77992   57743\n70884   21412\n91936   77547\n39673   53183\n31518   19763\n23066   48344\n45455   77547\n58606   32254\n33075   21971\n12200   19763\n42764   79555\n45004   94858\n87970   98880\n52319   38436\n81837   86922\n67858   57654\n86460   95056"))
